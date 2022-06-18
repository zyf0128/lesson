package com.zhong.app;

import com.sun.media.jfxmedia.logging.Logger;
import com.zhong.app.util.Md5Util;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

/**
 * @author zhuyin
 */
public class Md5Test {

    @Test
    public void testEncrypt(){

        String admin = Md5Util.encrypt("admin");
        System.out.println(admin);
    }
}
