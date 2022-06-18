package com.zhong.app.controller;

import com.zhong.app.entity.Video;
import com.zhong.app.entity.VideoBanner;
import com.zhong.app.service.VideoBannerService;
import com.zhong.app.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhuyin
 */
@Slf4j
@RestController
@RequestMapping("/api/v3/video-banner")
@Api(tags = "VideoBanner控制器")
public class VideoBannerController {
    @Autowired
    private VideoBannerService videoBannerService;

    /***
     * cli: http://localhost:5279/api/v3/video-banner/list
     * @return 所有的轮播图记录
     */
    @ApiOperation(value = "视频轮播图全查",notes = "全查的结果...")
    @GetMapping("/list")
    public Result list(){
        List<VideoBanner> result = videoBannerService.list();
//        System.out.println(1/0);
        return !result.isEmpty() ? Result.ok(result) : Result.fail();
    }

}
