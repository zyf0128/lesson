package com.zhong.app.mapper;

import com.zhong.app.entity.Video;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhuyin
 */
@Repository
public interface VideoMapper {

    /**
     * 按照主键查询一条视频记录
     * @param id 视频主键
     * @return 一条视频记录
     */
    @Select("select id, title, summary, cover_img, price, point, create_time " +
            "from lesson.video where id = #{param1}")
    Video  selectById(Integer id);

    /**
     * 全查视频
     * @return 所有视频
     */
    @Select("select id, title, summary, cover_img, price, point, create_time " +
            "from lesson.video ")
    List<Video> list();


    /**
     *
     * @param id 主键
     * @return 对应主键的单条视频信息
     */
    @Select("select  id, id as video_id, title, summary, cover_img, price, point, create_time " +
            "from video where id = #{param1}")
    @Results({
            @Result(id = true,column = "id", property = "id",jdbcType = JdbcType.INTEGER),
            @Result(column = "video_id",property = "chapters", jdbcType = JdbcType.INTEGER,
                    many = @Many(select = "com.zhong.app.mapper.ChapterMapper.selectByVideoId")
            )

    })
    Video selectByDetailById(Integer id);


}
