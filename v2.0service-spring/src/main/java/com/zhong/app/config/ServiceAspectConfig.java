package com.zhong.app.config;

import com.zhong.app.entity.User;
import com.zhong.app.util.NullUtil;
import com.zhong.app.util.PhoneUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author zhuyin
 */
@Slf4j
@Aspect
@Configuration
public class ServiceAspectConfig {

    @SneakyThrows
    @Around("execution(* com.zhong.app.service.ServiceImpl..*.*(..))")
    public Object aroundAdvice(ProceedingJoinPoint pjp) {
        Object[] args = pjp.getArgs();
        if (NullUtil.isNull(args)) {
            throw new NullPointerException("参数中存在null值");
        }

        Object returnValue = pjp.proceed(args);
        if (returnValue instanceof User) {
            User user =  (User) returnValue;
            if (user.getId() <= 0) {
                return user;
            }
            user.setPassword("");
            user.setPhone(PhoneUtil.check(user.getPhone()));
        }

        if (returnValue instanceof List && ((List) returnValue).get(0) instanceof User) {
            List<User> users = (List<User>) returnValue;
            users.forEach(user -> {
                user.setPassword("");
                user.setPhone(PhoneUtil.check(user.getPhone()));
            });
            return users;
        }

        log.info("方法调用成功...{}", pjp.getSignature());

        return returnValue;
    }

}
