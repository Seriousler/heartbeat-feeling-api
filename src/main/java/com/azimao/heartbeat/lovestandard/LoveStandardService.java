package com.azimao.heartbeat.lovestandard;

import com.azimao.heartbeat.common.entity.Wrapper;
import com.azimao.heartbeat.lovestandard.pojo.LoveStandard;

import java.util.List;

/**
 * @Author: 张隆
 * @Date: 2023/6/28 14:13
 * @Version: 1.0
 */
public interface LoveStandardService {

    Wrapper<List<LoveStandard>> list();
}
