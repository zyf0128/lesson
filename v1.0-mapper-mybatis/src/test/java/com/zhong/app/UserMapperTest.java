package com.zhong.app;

import com.zhong.app.entity.User;
import com.zhong.app.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhuyin
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    /**
     * 测试插入一条用户记录
     */
    @Test
    public void testInsert(){
        User user = new User();
        user.setUsername("zhaosi");
        user.setPassword("zhaosi123");
        user.setRealName("赵国强");
        user.setPhone("12345678912");
        user.setAvatar("zhaosi.jpg");
        user.setGender(1);
        log.info(userMapper.insert(user) > 0 ? "添加成功: user: " + user : "添加失败");
    }

    /**
     * 测试按照用户名查询一条用户记录
     */
    @Test
    public void testSelectByUsername(){
        log.info("user{}",userMapper.selectByUsername("zhaosi"));
    }

    /**
     * 测试按照用户主键查询一条用户记录
     */
    @Test
    public void testSelectById(){
        log.info("user{}",userMapper.selectById(1));
    }

    /***
     * 测试通过用户id 修改用户记录,账号和创建日期不准修改
     */
    @Test
    public void testUpdateById(){
        User user = new User();
        user.setId(1);
        user.setPassword("zhaosi-testUpdate");
        user.setRealName("赵国强");
        user.setPhone("12345678912");
        user.setAvatar("zhaosi.jpg");
        user.setGender(1);
        log.info(userMapper.updateById(user) > 0 ? "修改成功: user: " + user : "修改失败");
    }


    /**
     * 测试按照用户主键删除一条用户记录
     */
    @Test
    public void testDeleteById(){
        log.info(userMapper.deleteById(1) > 0 ? "删除成功": "删除失败");
    }




}
