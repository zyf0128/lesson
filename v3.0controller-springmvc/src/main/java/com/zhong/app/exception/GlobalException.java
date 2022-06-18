package com.zhong.app.exception;

import com.zhong.app.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhuyin
 */

@Slf4j
@ControllerAdvice("com.zhong")
public class GlobalException {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result exception(Exception e){
        return Result.fail(0,e.getMessage());
    }

}
