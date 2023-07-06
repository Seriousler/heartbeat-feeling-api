package com.azimao.heartbeat.interest;

import com.azimao.heartbeat.common.entity.Wrapper;
import com.azimao.heartbeat.interest.pojo.Interest;

import java.util.List;

/**
 * @Author: 张隆
 * @Date: 2023/6/28 11:22
 * @Version: 1.0
 */
public interface InterestService {

    Wrapper<List<Interest>> list();

}
