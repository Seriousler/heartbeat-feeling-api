package com.azimao.heartbeat.interest;

import com.azimao.heartbeat.common.entity.Wrapper;
import com.azimao.heartbeat.interest.pojo.Interest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: 张隆
 * @Date: 2023/6/21 16:47
 * @Version: 1.0
 */
@RestController
@RequestMapping("/interest")
public class InterestCtrl {

    @Autowired
    private InterestService interestService;

    @PostMapping("/list")
    public Wrapper<List<Interest>> list() {
        return interestService.list();
    }

}
