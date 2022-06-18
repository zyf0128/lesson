package com.zhong.app.mapper;

import com.zhong.app.entity.VideoBanner;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 16256
 */
@Repository
public interface VideoBannerMapper {
    /*
    练习 : 以下均为VideoBanner表的数据接口方法：
    - VideoBanner selectById(Integer id)`
    - int insert(VideoBanner videoBanner)`
    - int updateById(VideoBanner videoBanner)`
    - int deleteById(Integer id)`
    */
//--------------------------------------------------------------------------
    /**
     * 全查videoBanner
     * @return videoBanner list
     */
    @Select("select video_banner.id,video_banner.url,video_banner.src," +
            "video_banner.weight,video_banner.create_time from lesson.video_banner")
    List<VideoBanner> list();

    /**
     * 按照主键查询
     * @param id 主键
     * @return 返回一条查询结果
     */

    @Select("select video_banner.id,video_banner.url,video_banner.src," +
            "video_banner.weight,video_banner.create_time from lesson.video_banner " +
            "where video_banner.id = #{id}")
    VideoBanner selectById(Integer id);

    /**
     * 插入
     * @param videoBanner 待插入记录
     * @return 返回影响行数
     */

    @Insert("insert into lesson.video_banner (url, src, weight)" +
            "values(#{url},#{src},#{weight})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int insert(VideoBanner videoBanner);

    /**
     * 修改
     * @param videoBanner 参数
     * @return 返回影响的行数
     */
    @Update({"update lesson.video_banner set url = #{url},src = #{src}, weight = #{weight} where id = #{id}"
    })
    int updateById(VideoBanner videoBanner);

    /***
     * 按主键删除
     * @param id 主键
     * @return 返回受影响的行数
     */
    @Delete("delete from lesson.video_banner " +
            "where id = #{id}")
    int deleteById(Integer id);
}
