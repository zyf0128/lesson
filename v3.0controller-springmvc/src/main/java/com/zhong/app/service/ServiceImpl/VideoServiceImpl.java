package com.zhong.app.service.ServiceImpl;

import com.zhong.app.entity.Video;
import com.zhong.app.mapper.VideoMapper;
import com.zhong.app.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhuyin
 */
@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private  VideoMapper videoMapper;


    @Override
    public List<Video> list() {
        //查询成功,返回全部的Video表记录
        return videoMapper.list();
    }

    @Override
    public Video selectByDetailById(Integer id) {
        //查询成功,返回一条完成的Video表记录
        return videoMapper.selectByDetailById(id);
    }
}
