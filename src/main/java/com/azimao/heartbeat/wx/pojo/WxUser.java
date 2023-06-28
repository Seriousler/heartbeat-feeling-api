package com.azimao.heartbeat.wx.pojo;

import lombok.Data;

/**
 * @Author: 张隆
 * @Date: 2023/6/28 9:54
 * @Version: 1.0
 */
@Data
public class WxUser {

    /**
     * 用户在开放平台的唯一标识符，若当前小程序已绑定到微信开放平台帐号下会返回
     */
    private String unionid;
    /**
     * 用户唯一标识
     */
    private String openid;

}
