package com.azimao.heartbeat.feignclient.wx.pojo;

/**
 * @Author: 张隆
 * @Date: 2023/6/27 16:33
 * @Version: 1.0
 */
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

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getJs_code() {
        return js_code;
    }

    public void setJs_code(String js_code) {
        this.js_code = js_code;
    }

    public String getGrant_type() {
        return grant_type;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }
}
