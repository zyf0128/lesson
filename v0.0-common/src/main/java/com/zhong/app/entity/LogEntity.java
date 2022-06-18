package com.zhong.app.entity;

import lombok.Data;

/**
 * @author zhuyin
 */
@Data
public class LogEntity {
    private String date;
    private String level;
    private String thread;
    private String className;
    private String methodName;
    private String lineNumber;
    private String message;
}
