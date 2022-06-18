package com.zhong.app.util;

import java.util.UUID;

/**
 * @author zhuyin
 */
public class UuidUtil {

    public static String uuid(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
