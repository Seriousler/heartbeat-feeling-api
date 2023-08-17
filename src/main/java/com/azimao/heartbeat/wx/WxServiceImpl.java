package com.azimao.heartbeat.wx;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.azimao.heartbeat.common.entity.Wrapper;
import com.azimao.heartbeat.common.util.JwtUtils;
import com.azimao.heartbeat.feignclient.wx.WxClient;
import com.azimao.heartbeat.feignclient.wx.pojo.CgiBinToken;
import com.azimao.heartbeat.feignclient.wx.pojo.SnsJscode2session;
import com.azimao.heartbeat.user.UserService;
import com.azimao.heartbeat.user.pojo.user.UserSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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
    @Autowired
    private UserService userService;

    @Override
    public Wrapper<JSONObject> snsJscode2session(SnsJscode2session dto) {
        dto.setAppid(appId);
        dto.setSecret(secret);
        dto.setGrant_type("authorization_code");
        ResponseEntity<String> responseEntity = wxClient.snsJscode2session(dto);
        JSONObject jsonObject = JSONUtil.toBean(responseEntity.toString(), JSONObject.class);
        if (!"0".equals(jsonObject.get("errcode"))) {
            return Wrapper.error("获取失败");
        }
        String sessionKey = String.valueOf(jsonObject.get("session_key"));
        String unionid = String.valueOf(jsonObject.get("unionid"));
        String openid = String.valueOf(jsonObject.get("openid"));
        String jwtToken = JwtUtils.getJwtToken(openid, sessionKey);

        UserSaveDTO userSaveDTO = new UserSaveDTO();
        userSaveDTO.setOpenid(openid);
        userSaveDTO.setUnionid(unionid);
        userService.save(userSaveDTO);

        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("jwtToken", jwtToken);
        JSONObject jsonObject1 = new JSONObject(hashMap);
        return Wrapper.result(jsonObject1);
    }

    @Override
    public Wrapper<JSONObject> cgiBinToken() {
        CgiBinToken cgiBinToken = new CgiBinToken();
        cgiBinToken.setGrant_type("client_credential");
        cgiBinToken.setAppid(appId);
        cgiBinToken.setSecret(secret);
        ResponseEntity<String> responseEntity = wxClient.cgiBinToken(cgiBinToken);
        JSONObject jsonObject = JSONUtil.toBean(responseEntity.toString(), JSONObject.class);
        return Wrapper.result(jsonObject);
    }

    @Override
    public Wrapper<JSONObject> wxaBusinessGetuserphonenumber() {
        String access_token = "";
        ResponseEntity<String> responseEntity = wxClient.wxaBusinessGetuserphonenumber(access_token);
        JSONObject jsonObject = JSONUtil.toBean(responseEntity.toString(), JSONObject.class);
        return Wrapper.result(jsonObject);
    }

}
