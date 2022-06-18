package com.zhong.app.mapper;

import com.zhong.app.entity.VideoOrder;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 16256
 */
@Repository
public interface VideoOrderMapper {

    /**
     *
     * @param videoOrder
     * @return
     */
    @Insert("insert into lesson.video_order(order_no, state, total_fee, video_id, video_title, video_img, user_id, create_time) " +
            "values(#{orderNo},#{state},#{totalFee},#{videoId},#{videoTitle},#{videoImg},#{userId}, now() )")
    int insert(VideoOrder videoOrder);


    /**
     * 删除一条 视频订单
     * @param id 订单主键
     * @return 受影响的行数
     */
    @Delete("delete  from lesson.video_order where id = #{param1} ")
    int deleteById(Integer id);


    /**
     * 通过 用户主键和视频主键 来查询 视频的订单
     * @param userId 用户主键
     * @param videoId 视频主键
     * @return
     */
    @Select("select id, order_no, state, total_fee, video_id, video_title, video_img, user_id, create_time " +
            "from lesson.video_order " +
            "where user_id = #{param1} and video_id = #{param2} and state = 1 " )
    VideoOrder selectByUserIdAndVideoId(Integer userId,Integer videoId);

    /***
     * 通过用户主键来查询订单集合
     * @param userId 用户主键
     * @return 订单的集合
     */
    @Select("select id, order_no, state, total_fee, video_id, video_title, video_img, user_id, create_time " +
            "from lesson.video_order " +
            "where user_id =  #{param1} " )
    List<VideoOrder> selectByUserId(Integer userId);

    /**
     * 一对一级联查询
     * @param id 订单主键
     * @return
     */
    @Select("select id, order_no, state, total_fee, video_id, video_title, video_img, user_id, create_time " +
            "from lesson.video_order " +
            "where id = #{param1}")
    @Results({
            @Result(id = true, column = "id", property = "id", jdbcType = JdbcType.INTEGER),
            @Result(column = "user_id", property = "user", jdbcType = JdbcType.INTEGER,
                    one = @One(select = "com.zhong.app.mapper.UserMapper.selectById"))
    })
    VideoOrder selectDetailById(Integer id);

}
