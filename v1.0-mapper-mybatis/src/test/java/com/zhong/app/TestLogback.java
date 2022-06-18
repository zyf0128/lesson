package com.zhong.app;

import com.zhong.app.util.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * @author zhuyin
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestLogback {
    @Test
    public void testLog(){
        log.error("test....Log");
        throw new RuntimeException("test-LogBack");
    }
    @Test
    public void testLogback() throws IOException {
        LogUtil.parseLog("D:\\Workspace\\javabook03-lesson\\log\\my.log").
                forEach(logEntity -> log.info("logEntity:{}",logEntity));
    }





}
