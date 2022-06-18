package com.zhong.app.service;

import com.zhong.app.entity.Video;
import com.zhong.app.entity.VideoOrder;

import java.util.List;

/**
 * @author 16256
 */
public interface VideoOrderService {


    /**
     * - 若该用户已经购买过该视频，则返回-1，表示不允许重复购买。
     *     - 通过视频id查询该视频记录，若视频不存在则返回-2，表示参数出现问题。
     *     - 准备一条订单实体，订单号随机生成，创建日期为当前本地时间，订单状态为0表示未支付。
     *     - 查询该视频的第一集记录，若查询结果为空则抛出异常。
     *     - 插入播放记录，若插入失败则抛出异常。
     *     - 下单成功，返回1。
     * @param userId 用户主键
     * @param videoId 视频主键
     * @return 结果
     */
    int insert(Integer userId, Integer videoId);

    /**
     *
     * @return
     */
    List<VideoOrder> selectByUserId(Integer userId);
}
