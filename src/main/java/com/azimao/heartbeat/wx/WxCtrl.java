package com.azimao.heartbeat.wx;

import cn.hutool.json.JSONObject;
import com.azimao.heartbeat.common.entity.Wrapper;
import com.azimao.heartbeat.feignclient.wx.pojo.SnsJscode2session;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 张隆
 * @Date: 2023/6/27 16:24
 * @Version: 1.0
 */
@Tag(name = "wx", description = "对接微信")
@RestController
@RequestMapping("/wx")
public class WxCtrl {

    @Autowired
    private WxService wxService;

    @PostMapping("/sns/jscode2session")
    public Wrapper<JSONObject> snsJscode2session(@RequestBody SnsJscode2session dto) {
        return wxService.snsJscode2session(dto);
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
