package com.azimao.heartbeat.wx;

import cn.hutool.json.JSONObject;
import com.azimao.heartbeat.common.entity.Wrapper;

/**
 * @Author: 张隆
 * @Date: 2023/6/27 16:25
 * @Version: 1.0
 */
public interface WxService {

    Wrapper<JSONObject> snsJscode2session();

    Wrapper<JSONObject> cgiBinToken();

    Wrapper<JSONObject> wxaBusinessGetuserphonenumber();
}
