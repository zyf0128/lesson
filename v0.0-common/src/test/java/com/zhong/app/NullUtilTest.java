package com.zhong.app;

import com.zhong.app.util.NullUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author zhuyin
 */
@Slf4j
public class NullUtilTest {
    @Test
    public void testIsBlank(){
        boolean blank = NullUtil.isBlank("admin", "", "zhaosi");
        System.out.println(blank);

        boolean admin = NullUtil.isNull(null, "admin");
        log.info("admin");

    }
}
