package com.zhong.app.service;

import com.zhong.app.entity.Video;
import com.zhong.app.mapper.VideoMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zhuyin
 */
public interface VideoService {


    List<Video> list();

    Video selectByDetailById(Integer id);

}
