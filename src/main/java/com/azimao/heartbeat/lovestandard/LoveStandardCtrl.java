package com.azimao.heartbeat.lovestandard;

import com.azimao.heartbeat.common.entity.Wrapper;
import com.azimao.heartbeat.lovestandard.pojo.LoveStandard;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: 张隆
 * @Date: 2023/6/28 13:55
 * @Version: 1.0
 */
@Tag(name = "loveStandard", description = "恋爱标准")
@RestController
@RequestMapping("/love/standard")
public class LoveStandardCtrl {

    @Autowired
    private LoveStandardService loveStandardService;

    @PostMapping("/list")
    public Wrapper<List<LoveStandard>> list() {
        return loveStandardService.list();
    }
}
