package com.zhong.app.entity;


import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 视频-集表
 * </p>
 *
 * @author ${author}
 * @since 2022-05-27
 */
@Data
public class Episode implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 集的标题
     */
    private String title;

    /**
     * 0免费，1付费
     */
    private Integer free;

    /**
     * 视频播放地址
     */
    private String playUrl;

    /**
     * 视频内第几集
     */
    private Integer orderInVideo;

    /**
     * 章内第几集
     */
    private Integer orderInChapter;

    /**
     * chapter表外键
     */
    private Integer chapterId;

    /**
     * video表外键
     */
    private Integer videoId;

    /**
     * 集的创建时间
     */
    private Date createTime;


}
