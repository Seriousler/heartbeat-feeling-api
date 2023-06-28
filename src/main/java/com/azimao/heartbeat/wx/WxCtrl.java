package com.azimao.heartbeat.wx;

import cn.hutool.json.JSONObject;
import com.azimao.heartbeat.common.entity.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 张隆
 * @Date: 2023/6/27 16:24
 * @Version: 1.0
 */
@RestController
@RequestMapping("/wx")
public class WxCtrl {

    @Autowired
    private WxService wxService;

    @PostMapping("/sns/jscode2session")
    public Wrapper<JSONObject> snsJscode2session() {
        return wxService.snsJscode2session();
    }

    @PostMapping("/cgi-bin/token")
    public Wrapper<JSONObject> cgiBinToken() {
        return wxService.cgiBinToken();
    }

    @PostMapping("/wxa/business/getuserphonenumber")
    public Wrapper<JSONObject> wxaBusinessGetuserphonenumber() {
        return wxService.wxaBusinessGetuserphonenumber();
    }

}
