package com.zhong.app.service.ServiceImpl;

import com.zhong.app.entity.Episode;
import com.zhong.app.entity.PlayRecord;
import com.zhong.app.entity.Video;
import com.zhong.app.entity.VideoOrder;
import com.zhong.app.mapper.EpisodeMapper;
import com.zhong.app.mapper.PlayRecordMapper;
import com.zhong.app.mapper.VideoMapper;
import com.zhong.app.mapper.VideoOrderMapper;
import com.zhong.app.service.VideoOrderService;
import com.zhong.app.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author zhuyin
 */
@Service
public class VideoOrderServiceImpl implements VideoOrderService {

    @Autowired
    private VideoOrderMapper videoOrderMapper;
    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private EpisodeMapper episodeMapper;
    @Autowired
    private PlayRecordMapper playRecordMapper;

    /**
     *     /*
     *     **武技：** 开发VideoOrder表业务层代码：视频下单：
     * - VideoOrderService接口：`int insert(Integer userId, Integer videoId)`：
     *     - 方法需要添加 `@Transactional(rollbackFor = Exception.class)` 本地事务保护。

     *
     *     - 查询该视频的第一集记录，若查询结果为空则抛出异常。
     *     - 插入播放记录，若插入失败则抛出异常。
     *     - 下单成功，返回1。
     * - VideoOrderService管理：同上。
     * - VideoOrderService测试：同上：
     *     - tst：`service.VideoOrderServiceTest.testInsert()`：测试同上。
     *      */

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insert(Integer userId, Integer videoId) {

        // 若该用户已经购买过该视频，则返回-1，表示不允许重复购买。
        if(videoOrderMapper.selectByUserIdAndVideoId(userId,videoId) != null){
            return -1;
        }
        //通过视频id查询该视频记录，若视频不存在则返回-2，表示参数出现问题
        Video video = videoMapper.selectById(videoId);
        if( video == null){
            return  -2;
        }
//        准备一条订单实体，订单号随机生成，创建日期为当前本地时间，订单状态为0表示未支付。
        VideoOrder videoOrder = new VideoOrder();
        videoOrder.setCreateTime(new Date());
        videoOrder.setOrderNo(UuidUtil.uuid());
        videoOrder.setState(1);
        videoOrder.setTotalFee(video.getPrice());
        videoOrder.setUserId(userId);
        videoOrder.setVideoId(videoId);
        videoOrder.setVideoTitle(video.getTitle());
        videoOrder.setVideoImg(video.getCoverImg());


        Episode episode = episodeMapper.selectFirstEpisodeByVideoId(videoId);
//        查询该视频的第一集记录，若查询结果为空则抛出异常。
        if(episode == null){
            throw  new RuntimeException("视频未录入集, 请联系运营人员");
        }

        if(videoOrderMapper.insert(videoOrder) <= 0){
            throw new RuntimeException("下单失败..");
        }


        PlayRecord playRecord = new PlayRecord();
        playRecord.setCreateTime(new Date());
        playRecord.setEpisodeId(episode.getId());
        playRecord.setCurrentNum(episode.getOrderInVideo());
        playRecord.setUserId(userId);
        playRecord.setVideoId(videoId);
//        - 插入播放记录，若插入失败则抛出异常。
        if(playRecordMapper.insert(playRecord) <= 0){
            throw new RuntimeException("视频播放记录添加失败..");
        }
        return 1;
    }

    @Override
    public List<VideoOrder> selectByUserId(Integer userId) {
        return videoOrderMapper.selectByUserId(userId);
    }


}
