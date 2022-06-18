package com.zhong.app.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 视频表
 * </p>
 *
 * @author ${author}
 * @since 2022-05-27
 */
@Data
public class Video implements Serializable {


    /**
     * 主键
     */
    private Integer id;

    /**
     * 视频标题
     */
    private String title;

    /**
     * 视频概述
     */
    private String summary;

    /**
     * 视频封面图
     */
    private String coverImg;

    /**
     * 视频价格，单位元
     */
    private Integer price;

    /**
     * 视频评分，默认7.0，最高10分
     */
    private BigDecimal point;

    /**
     * 视频创建时间
     */
    private Date createTime;

    /**
     * 每个视频有多个章
     */
    List<Chapter> chapters;
}
