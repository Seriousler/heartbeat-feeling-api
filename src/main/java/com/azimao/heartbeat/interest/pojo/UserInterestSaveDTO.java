package com.azimao.heartbeat.interest.pojo;

import lombok.Data;

import java.util.List;

/**
 * @Author: 张隆
 * @Date: 2023/6/28 14:00
 * @Version: 1.0
 */
@Data
public class UserInterestSaveDTO {

    /**
     * 用户openid
     */
    private String openid;
    /**
     * 用户兴趣爱好列表
     */
    private List<String> InterestList;

}
