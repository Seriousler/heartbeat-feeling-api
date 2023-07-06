package com.azimao.heartbeat.feignclient.wx.pojo;

import lombok.Data;

/**
 * @Author: 张隆
 * @Date: 2023/6/27 16:33
 * @Version: 1.0
 */
@Data
public class SnsJscode2session {

    /**
     * 小程序 appId
     */
    private String appid;
    /**
     * 小程序 appSecret
     */
    private String secret;
    /**
     * 登录时获取的 code，可通过wx.login获取
     */
    private String js_code;
    /**
     * 授权类型，此处只需填写 authorization_code
     */
    private String grant_type;

}
