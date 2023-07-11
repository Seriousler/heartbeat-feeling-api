package com.azimao.heartbeat.wx;

import cn.hutool.json.JSONObject;
import com.azimao.heartbeat.common.entity.Wrapper;
import com.azimao.heartbeat.feignclient.wx.WxClient;
import com.azimao.heartbeat.feignclient.wx.pojo.CgiBinToken;
import com.azimao.heartbeat.feignclient.wx.pojo.SnsJscode2session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 张隆
 * @Date: 2023/6/27 16:26
 * @Version: 1.0
 */
@Service
public class WxServiceImpl implements WxService {

    static final String appId = "wx208da25e78289c61";
    static final String secret = "5c3b4db13173472e966eb55eabc8dde6";

    @Autowired
    private WxClient wxClient;

    @Override
    public Wrapper<JSONObject> snsJscode2session(SnsJscode2session dto) {
        dto.setAppid(appId);
        dto.setSecret(secret);
        dto.setGrant_type("authorization_code");
        JSONObject jsonObject = wxClient.snsJscode2session(dto);
        return Wrapper.result(jsonObject);
    }

    @Override
    public Wrapper<JSONObject> cgiBinToken() {
        CgiBinToken cgiBinToken = new CgiBinToken();
        cgiBinToken.setGrant_type("client_credential");
        cgiBinToken.setAppid(appId);
        cgiBinToken.setSecret(secret);
        JSONObject jsonObject = wxClient.cgiBinToken(cgiBinToken);
        return Wrapper.result(jsonObject);
    }

    @Override
    public Wrapper<JSONObject> wxaBusinessGetuserphonenumber() {
        String access_token = "";
        JSONObject jsonObject = wxClient.wxaBusinessGetuserphonenumber(access_token);
        return Wrapper.result(jsonObject);
    }

}
