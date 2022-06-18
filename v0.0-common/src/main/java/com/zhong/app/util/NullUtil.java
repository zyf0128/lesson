package com.zhong.app.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @author zhuyin
 */
public class NullUtil {
    public static boolean isBlank(String ... params){
        for(String param : params){
            if(StringUtils.isBlank(param)){
                return true;
            }
        }
        return false;
    }

    public static boolean isNull(Object ... params){
        for(Object param : params){
            if(param == null){
                return true;
            }
        }
        return false;
    }


}
