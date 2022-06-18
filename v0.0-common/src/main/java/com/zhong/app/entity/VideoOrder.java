package com.zhong.app.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 视频订单表
 * </p>
 *
 * @author ${author}
 * @since 2022-05-27
 */
@Data
public class VideoOrder implements Serializable {


    /**
     * 主键
     */
    private Integer id;

    /**
     * 订单流水号
     */
    private String orderNo;

    /**
     * 0未支付，1已支付
     */
    private Integer state;

    /**
     * 支付金额
     */
    private Integer totalFee;

    /**
     * 视频表外键
     */
    private Integer videoId;

    /**
     * 视频标题，冗余字段
     */
    private String videoTitle;

    /**
     * 视频图片，冗余字段
     */
    private String videoImg;

    /**
     * 用户表外键
     */
    private Integer userId;

    /**
     * 订单生成时间
     */
    private Date createTime;

    /**
     * 用户信息
     */
    private User user;

}
