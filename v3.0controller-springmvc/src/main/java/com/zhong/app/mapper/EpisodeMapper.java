package com.zhong.app.mapper;

import com.zhong.app.entity.Episode;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 16256
 */
@Repository
public interface EpisodeMapper {


    /**
     * 根据视频主键查询指定视频的第一集
     * @param videoId 视频主键
     * @return 返回视频的第一集
     */
    @Select("select id, title, free, play_url, order_in_video, order_in_chapter, chapter_id, video_id, create_time " +
            "from lesson.episode where video_id = #{param1} limit 1 ")
    Episode selectFirstEpisodeByVideoId(Integer videoId);

    /**
     * 根据章节主键查询视频
     * @param chapterId 章节主键
     * @return 返回本章节的视频的集合
     */
    @Select("select id, title, free, play_url, order_in_video, order_in_chapter, chapter_id, video_id, create_time " +
            "from lesson.episode where video_id = #{param1}")
    List<Episode> selectByChapterId(Integer chapterId);




}
