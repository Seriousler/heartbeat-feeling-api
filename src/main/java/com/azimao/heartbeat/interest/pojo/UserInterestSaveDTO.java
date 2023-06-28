package com.azimao.heartbeat.interest.pojo;

import java.util.List;

/**
 * @Author: 张隆
 * @Date: 2023/6/28 14:00
 * @Version: 1.0
 */
public class UserInterestSaveDTO {

    /**
     * 用户openid
     */
    private String openid;
    /**
     * 用户兴趣爱好列表
     */
    private List<String> InterestList;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public List<String> getInterestList() {
        return InterestList;
    }

    public void setInterestList(List<String> interestList) {
        InterestList = interestList;
    }
}
