package com.zhong.app.entity;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 播放记录表
 * </p>
 *
 * @author ${author}
 * @since 2022-05-27
 */
@Data
public class PlayRecord implements Serializable {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户表外键
     */
    private Integer userId;

    /**
     * 视频表外键
     */
    private Integer videoId;

    /**
     * 当前播放第几集
     */
    private Integer currentNum;

    /**
     * 当前播放第几集视频的id
     */
    private Integer episodeId;

    /**
     * 创建时间
     */
    private Date createTime;


}
