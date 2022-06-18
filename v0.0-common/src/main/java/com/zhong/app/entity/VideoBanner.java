package com.zhong.app.entity;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 视频轮播图表
 * </p>
 *
 * @author ${author}
 * @since 2022-05-27
 */
@Data
public class VideoBanner implements Serializable {


    /**
     * 主键
     */
    private Integer id;

    /**
     * 跳转地址
     */
    private String url;

    /**
     * 图片地址
     */
    private String src;

    /**
     * 数字越小排越前
     */
    private Integer weight;

    /**
     * 创建时间
     */
    private Date createTime;


}
