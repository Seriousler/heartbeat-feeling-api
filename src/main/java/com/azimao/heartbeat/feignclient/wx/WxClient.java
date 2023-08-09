package com.azimao.heartbeat.feignclient.wx;

import cn.hutool.json.JSONObject;
import com.azimao.heartbeat.feignclient.wx.pojo.CgiBinToken;
import com.azimao.heartbeat.feignclient.wx.pojo.SnsJscode2session;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 张隆
 * @Date: 2023/6/27 10:58
 * @Version: 1.0
 */
@FeignClient(name = "wx", url = "${openfeign.address.wx}")
public interface WxClient {

    @GetMapping("/sns/jscode2session")
    ResponseEntity<String> snsJscode2session(@Valid @SpringQueryMap SnsJscode2session snsJscode2session);

    @GetMapping("/cgi-bin/token")
    ResponseEntity<String> cgiBinToken(@Valid @SpringQueryMap CgiBinToken cgiBinToken);

    @PostMapping("/wxa/business/getuserphonenumber")
    ResponseEntity<String> wxaBusinessGetuserphonenumber(String access_token);

}
