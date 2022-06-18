package com.zhong.app.service;

import com.zhong.app.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author 16256
 */
@Service
public interface UserService {

    /**
     * 注册
     * @param user 用户实体
     * @return 1 注册成功,0 注册失败,-1参数异常
     */
    int register(User user);

    /**
     *     - 根据账号查询用户记录，若记录为空，则返回空User实体。
     *     - 使用自封装的MD5工具对密码进行MD5加密后比对密码，若比对失败则返回空User实体。
     * @param username 账号
     * @param password 密码
     * @return
     */
    User login(String username, String password);

    /**
     * 查询个人信息
     * @param id
     * @return
     */
    User selectById(Integer id);


}
