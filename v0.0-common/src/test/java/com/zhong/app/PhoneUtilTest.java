package com.zhong.app;

import com.zhong.app.util.PhoneUtil;
import org.junit.Test;

import java.nio.charset.CharsetEncoder;

/**
 * @author zhuyin
 */
public class PhoneUtilTest {

    @Test
    public void testCheck(){
        String check = PhoneUtil.check("123");
        System.out.println(check);
    }
    @Test
    public void testCheck2(){
        String check = PhoneUtil.check(null);
        System.out.println(check);
    }
    @Test
    public void testCheck3(){
        String check = PhoneUtil.check("19574235726");
        System.out.println(check);
    }
}
