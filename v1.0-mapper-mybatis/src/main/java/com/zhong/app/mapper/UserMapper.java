package com.zhong.app.mapper;

import com.zhong.app.entity.PlayRecord;
import com.zhong.app.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * @author 16256
 */
@Repository
public interface UserMapper {
/*

- PlayRecord表: int insert(PlayRecord playRecord)`
- User表:     int insert(User user)`
- Order表：`int insert(VideoOrder videoOrder)`

**练习：** 开发以下接口方法：
- VideoOrder表：`int deleteById(Integer id)`
- PlayRecord表：`int deleteById(Integer id)`
 */


    /**
     * 插入一条用户记录
     * @param user 用户实体
     * @return 返回受影响行数
     */
    @Insert("insert into lesson.user(username, password, real_name, gender, avatar, phone, create_time) " +
            "values(#{username},#{password},#{realName},#{gender},#{avatar},#{phone},now())")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(User user);

    /**
     * 按照用户名查一条用户记录
     * @param username 用户名
     * @return 返回一条用户记录
     */
    @Select("select id, username, password, real_name, gender, avatar, phone, create_time from lesson.user " +
            "where username = #{param1}")
    User selectByUsername(String username);

    /***
     * 按照主键查询一条用户记录
     * @param id 用户主键
     * @return 返回一条用户记录
     */
    @Select("select id, username, password, real_name, gender, avatar, phone, create_time from lesson.user " +
            "where id = #{param1}")
    User selectById (Integer id);

    /***
     * 通过用户id 修改用户记录,账号和创建日期不准修改
     * @param user 用户实体
     * @return 受影响的条目数
     */
    @Update("update lesson.user set " +
            "password = #{password}," +
            "real_name = #{realName}, " +
            "gender = #{gender}," +
            "avatar = #{avatar}," +
            "phone = #{phone}" +
            "where id = #{id}")
    int updateById(User user);

    /**
     * 根据用户主键删除一条用户记录
     * @param id 用户主键
     * @return  受影响的条目数
     */
    @Delete("delete from lesson.user where id = #{param1}")
    int deleteById(Integer id);

}
