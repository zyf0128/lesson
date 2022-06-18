package com.zhong.app.service.ServiceImpl;

import com.zhong.app.entity.User;
import com.zhong.app.mapper.UserMapper;
import com.zhong.app.service.UserService;
import com.zhong.app.util.Md5Util;
import com.zhong.app.util.NullUtil;
import com.zhong.app.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

/**
 * @author zhuyin
 */
@Service
public class UserServiceImpl implements UserService {

    /*
    - 若参数密码为空，直接返回-1，表示参数异常。
    - 若参数中真实姓名为空，则随机生成一个不带连接符的UUID作为用户真实姓名。
    - 若参数中头像为空，则使用 `default-avatar.jpg` 系统默认头像作为用户头像。
    - 使用自封装的 MD5 加密工具对密码进行MD5加密后，添加用户记录
     */
    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    @Override
    public int register(User user) {

        if(NullUtil.isBlank(user.getPassword())){
            return -1;
        }

        if(NullUtil.isBlank(user.getUsername()) ){
            String uuid = UuidUtil.uuid();
            user.setUsername(uuid);
        }

        if(NullUtil.isBlank()){
            user.setAvatar("default-avatar.jpg");
        }

        String encrypt = Md5Util.encrypt(user.getPassword());
        user.setPassword(encrypt);
        return userMapper.insert(user) > 0 ? 1 : 0 ;
    }


    /**
     *     - 根据账号查询用户记录，若记录为空，则返回空User实体。
     *     - 使用自封装的MD5工具对密码进行MD5加密后比对密码，若比对失败则返回空User实体。
     * @param username 账号
     * @param password 密码
     * @return
     */
    @Override
    public User login(String username, String password) {

        User user = userMapper.selectByUsername(username);
        if(NullUtil.isNull(user)){
            User user1  = new User();
            user1.setId(-1);
            user1.setUsername("用户不存在");
            return user1;
        }

        String encrypt = Md5Util.encrypt(password);

        if(!encrypt.equals(user.getPassword())){
            User user2 = new User();
            user2.setId(-2);
            user2.setPassword("密码错误");
            return user2;
        }
        return user;
    }

    /**
     * 查询个人信息
     * @param id
     * @return
     */
    @Override
    public User selectById(Integer id) {

        User user = userMapper.selectById(id);

        if(NullUtil.isNull(user)){
            return new User();
        }

        return user;
    }


}
