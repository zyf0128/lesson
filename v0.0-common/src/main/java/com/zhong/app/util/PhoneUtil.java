package com.zhong.app.util;

/**
 * @author zhuyin
 */
public class PhoneUtil {

    private final static Integer PHONE_NUMBER_DIGITS = 11;
    public static String  check(String phone){
        if(phone == null){
            throw  new RuntimeException("phone is null");
        }

        if(phone.length() != PHONE_NUMBER_DIGITS){
            throw  new RuntimeException("wrong phone number format");
        }

        return phone.replaceAll("(\\d{3})\\d*(\\d{4})", "$1****$2");
    }
}
