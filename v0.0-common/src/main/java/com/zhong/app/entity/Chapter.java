package com.zhong.app.entity;


import java.util.Date;
import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 视频-章表
 * </p>
 *
 * @author ${author}
 * @since 2022-05-27
 */
@Data
public class Chapter implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 章的标题
     */
    private String title;

    /**
     * 视频内第几章
     */
    private Integer orderInVideo;

    /**
     * video表外键
     */
    private Integer videoId;

    /**
     * 章的创建时间
     */
    private Date createTime;

    /**
     * 每一章有很多集
     */
    private List<Episode> episodes;
}
