package com.zhong.app.mapper;

import com.zhong.app.entity.PlayRecord;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

/**
 * @author 16256
 */
@Repository
public interface PlayRecordMapper {

    /**
     *  添加一条播放记录
     * @param playRecord 播放记录
     * @return 受影响的行数
     */
    @Insert("insert into lesson.play_record(user_id, video_id, current_num, episode_id, create_time) " +
            "values(#{userId},#{videoId},#{currentNum},#{episodeId},now() )")
    int insert(PlayRecord playRecord);

    /**
     * 删除一条播放记录
     * @param id 播放记录的 主键
     * @return 受影响的行数
     */
    @Delete("delete  from lesson.play_record where id = #{param1} ")
    int deleteById(Integer id);

}
