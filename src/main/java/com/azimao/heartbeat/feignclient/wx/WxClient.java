package com.azimao.heartbeat.feignclient.wx;

import cn.hutool.json.JSONObject;
import com.azimao.heartbeat.feignclient.wx.pojo.CgiBinToken;
import com.azimao.heartbeat.feignclient.wx.pojo.SnsJscode2session;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author: 张隆
 * @Date: 2023/6/27 10:58
 * @Version: 1.0
 */
@FeignClient(name = "wx", url = "${openfeign.address.wx}")
public interface WxClient {

    @GetMapping("/sns/jscode2session")
    JSONObject snsJscode2session(@RequestBody SnsJscode2session snsJscode2session);

    @GetMapping("/cgi-bin/token")
    JSONObject cgiBinToken(@RequestBody CgiBinToken cgiBinToken);

    @PostMapping("/wxa/business/getuserphonenumber")
    JSONObject wxaBusinessGetuserphonenumber(String access_token);

}
