package com.zhong.app.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * @author zhuyin
 */
public class Md5Util {
    public static String encrypt(String data) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] array = md5.digest(data.getBytes(StandardCharsets.UTF_8));
            StringBuilder builder = new StringBuilder();
            for (byte item : array) {
                builder.append(Integer.toHexString((item & 0xFF) | 0x100), 1, 3);
            }
            return builder.toString().toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
