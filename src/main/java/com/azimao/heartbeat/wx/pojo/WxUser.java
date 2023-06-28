package com.azimao.heartbeat.wx.pojo;

/**
 * @Author: 张隆
 * @Date: 2023/6/28 9:54
 * @Version: 1.0
 */
public class WxUser {

    /**
     * 用户在开放平台的唯一标识符，若当前小程序已绑定到微信开放平台帐号下会返回
     */
    private String unionid;
    /**
     * 用户唯一标识
     */
    private String openid;

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
}
