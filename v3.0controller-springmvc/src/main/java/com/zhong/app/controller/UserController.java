package com.zhong.app.controller;

import com.zhong.app.entity.User;
import com.zhong.app.group.InsertGroup;
import com.zhong.app.service.UserService;
import com.zhong.app.util.Result;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhuyin
 */
@Slf4j
@RestController
@RequestMapping("/api/v3/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户注册",notes = "用户注册方法需要进行token验证")
    @PostMapping("register")
    public Result register(@Validated(InsertGroup.class) @RequestBody User user
    , BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            throwValidationException(bindingResult);
        }
        return userService.register(user)  > 0 ? Result.ok() : Result.fail();
    }

    @ApiOperation(value = "用户登录", notes = "登录成功会返回用户信息")
    @RequestMapping("/login")
    public Result login(@ApiParam(value = "账号",required = true,example = "mario")
                        @RequestParam String username,
                        @ApiParam(value = "密码",required = true,example = "mario")
                        @RequestParam String password){
        User user = userService.login(username, password);
        if(user.getId() == -1){
            log.error("用户不存在");
            return Result.fail(user.getId(),user.getUsername());
        }
        if(user.getId() == -2){
            log.error("密码错误");
            return Result.fail(user.getId(),user.getPassword());
        }
        log.info("登陆成功");
        return Result.ok(user);
    }

    /**
     * 当实体参数未通过HibernateValidated校验时，记录日志并抛出运行时异常
     *
     * @param bindingResult 校验错误实例
     */
    private void throwValidationException(BindingResult bindingResult) {
        for (FieldError error : bindingResult.getFieldErrors()) {
            String errorMsg = String.format("%s 参数的 %s 属性爆发错误：%s",
                    error.getObjectName(),
                    error.getField(),
                    error.getDefaultMessage());
            log.info(errorMsg);
        // 手动抛出异常，被全局异常处理捕获
            throw new RuntimeException(errorMsg);
        }
    }




}
