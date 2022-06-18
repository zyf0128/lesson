package com.zhong.app;

import com.zhong.app.entity.VideoBanner;
import com.zhong.app.entity.VideoOrder;
import com.zhong.app.mapper.VideoOrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhuyin
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class VideoOrderMapperTest {
    @Autowired
    private VideoOrderMapper videoOrderMapper;

    @Test
    public void testInsert(){
        VideoOrder videoOrder = new VideoOrder();
        videoOrder.setOrderNo("123456");
        videoOrder.setState(0);
        videoOrder.setTotalFee(123);
        videoOrder.setVideoId(1);
        videoOrder.setVideoTitle("title-test");
        videoOrder.setVideoImg("video01.jpg");
        videoOrder.setUserId(1);
        log.info(videoOrderMapper.insert(videoOrder) > 0 ? "插入成功: " + videoOrder : "插入失败");
    }

    @Test
    public void testDeleteById(){
        log.info(videoOrderMapper.deleteById(1) > 0 ? "删除成功" : "删除失败");
    }

    @Test
    public void testSelectByUserIdAndVideoId(){
        log.info("VideoOrder{}", videoOrderMapper.selectByUserIdAndVideoId(1,1));
    }
    @Test
    public void testSelectByUserId(){
        log.info("VideoOrders{}", videoOrderMapper.selectByUserId(1));
    }

    /**
     *
     */
    @Test
    public void testSelectDetailById(){
        log.info("VideoOrder{}", videoOrderMapper.selectDetailById( 1 ));
    }






}
