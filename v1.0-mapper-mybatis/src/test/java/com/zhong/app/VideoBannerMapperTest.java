package com.zhong.app;

import com.alibaba.druid.sql.visitor.functions.Now;
import com.zhong.app.entity.VideoBanner;
import com.zhong.app.mapper.VideoBannerMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Time;

/**
 * @author zhuyin
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class VideoBannerMapperTest {
    @Autowired
    VideoBannerMapper videoBannerMapper;

    /**
     * 测试全查
     */
    @Test
    public void testList(){
        log.info("result: {}",videoBannerMapper.list());
    }


    /**
     * 测试插入一条记录
     */
    @Test
    public void testInsert(){
        VideoBanner v = new VideoBanner();
        v.setUrl("url-banner-test-insert");
        v.setSrc("src-banner-test-insert");
        v.setWeight(2);
        log.info("result: {}",videoBannerMapper.insert(v));
    }

    /**
     * 测试按主键查询一条
     */
    @Test
    public void testSelectById(){
        log.info("result: {}",videoBannerMapper.selectById(4));
    }

    /**
     * 测试按照主键修改
     */
    @Test
    public void testUpdate(){
        VideoBanner v =new VideoBanner();
        v.setId(4);
        v.setUrl("url-banner-UpdateTest");
        v.setSrc("src-banner-UpdateTest");
        v.setWeight(2);
        log.info("result: {}",videoBannerMapper.updateById(v));
    }

    /**
     * 测试按照主键删除
     */
    @Test
    public void testDeleteById(){
        log.info("result: {}",videoBannerMapper.deleteById(4));
    }




}
