package com.zhong.app.service.ServiceImpl;

import com.zhong.app.entity.VideoBanner;
import com.zhong.app.mapper.VideoBannerMapper;
import com.zhong.app.service.VideoBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhuyin
 */
@Service
public class VideoBannerServiceImpl implements VideoBannerService {

    @Autowired
    VideoBannerMapper videoBannerMapper;


    @Override
    public List<VideoBanner> list() {

        return  videoBannerMapper.list();
    }
}
