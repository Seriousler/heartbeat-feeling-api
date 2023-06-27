package com.azimao.heartbeat.feignclient.wx.pojo;

/**
 * @Author: 张隆
 * @Date: 2023/6/27 11:17
 * @Version: 1.0
 */
public class CgiBinToken {

    /**
     * 填写 client_credential
     */
    private String grant_type;
    /**
     * 小程序唯一凭证，即 AppID，可在「微信公众平台 - 设置 - 开发设置」页中获得。（需要已经成为开发者，且帐号没有异常状态）
     */
    private String appid;
    /**
     * 小程序唯一凭证密钥，即 AppSecret，获取方式同 appid
     */
    private String secret;

    public String getGrant_type() {
        return grant_type;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }

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
}
