package com.zhong.app.entity;

import java.util.Date;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.zhong.app.group.InsertGroup;
import com.zhong.app.group.UpdateGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author ${author}
 * @since 2022-05-27
 */
@Data
@ApiModel(value = "用户实体类",description = "实体类的详细描述...")
public class User implements Serializable {

    /**
     * 主键
     */
    @ApiModelProperty(value = "主键",example = "1")
    @JsonProperty("id")
    @Null(message = "添加业务中必须为null", groups = InsertGroup.class)
    @NotNull(message = "修改业务中必须不为null", groups = UpdateGroup.class)
    private Integer id;

    /**
     * 账号
     */
    @ApiModelProperty(value = "用户名",example = "Mario")
    @JsonProperty("username")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码",example = "mario")
    @JsonProperty("password")
    private String password;

    /**
     * 真实姓名
     */
    @ApiModelProperty(value = "真实姓名",example = "马里奥")
    @JsonProperty("real-name")
    private String realName;

    /**
     * 性别，0女，1男，2保密
     */
    @ApiModelProperty(value = "性别",example = "1")
    @JsonProperty("gender")
    private Integer gender;

    /**
     * 头像图片地址
     */
    @ApiModelProperty(value = "默认头像",example = "mario-avatar.jpg")
    @JsonProperty("avatar")
    private String avatar;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "电话号码",example = "12312312312")
    @JsonProperty("phone")
    private String phone;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间",example = "2022-06-18 08:08:08")
    @JsonProperty(value = "creat-time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "UTC")
    private Date createTime;

}
