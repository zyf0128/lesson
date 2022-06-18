package com.zhong.app.mapper;

import com.zhong.app.entity.Chapter;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 16256
 */
@Repository
public interface ChapterMapper {

    /**
     *
     * @param videoId 视频id
     * @return 根据视频 id 查询章
     */
    @Select("select id, id as chapter_id, title, order_in_video, video_id, create_time " +
            "from chapter where video_id = #{param1}")
    @Results({
            @Result(id = true, column = "id",property = "id",jdbcType = JdbcType.INTEGER),
            @Result(column = "chapter_id",property = "episodes",javaType = List.class,
                    many = @Many(select = "com.zhong.app.mapper.EpisodeMapper.selectByChapterId")
            )
    })
    List<Chapter> selectByVideoId(Integer videoId);
}
