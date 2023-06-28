package com.azimao.heartbeat.user.pojo;

import com.azimao.heartbeat.common.entity.CommonEntity;
import com.azimao.heartbeat.user.enums.EducationEnum;
import com.azimao.heartbeat.user.enums.IncomeEnum;
import com.azimao.heartbeat.user.enums.MaritalEnum;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Author: 张隆
 * @Date: 2023/6/21 15:59
 * @Version: 1.0
 */
@Data
@TableName("hf_user")
public class User extends CommonEntity {

    /**
     * 用户openid
     */
    private String openid;
    /**
     * 用户编码
     */
    private String userCode;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 用户昵称
     */
    private String nickName;
    /**
     * 用户微信头像
     */
    private String avatarUrl;
    /**
     * 性别：1：男，2：女，0：未知
     */
    private Integer gender;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 出生日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date birthday;
    /**
     * 婚姻状况
     */
    private MaritalEnum marital;
    /**
     * 学历
     */
    private EducationEnum education;
    /**
     * 收入
     */
    private IncomeEnum income;
    /**
     * 国家
     */
    private String country;
    /**
     * 省
     */
    private String province;
    /**
     * 市
     */
    private String city;
    /**
     * 区
     */
    private String town;
    /**
     * 地址
     */
    private String address;
    /**
     * 语言
     */
    private String language;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 身份证号码
     */
    private String identityCard;
    /**
     * 用户等级：1：普通用户，2：会员用户
     */
    private Integer level;

}
