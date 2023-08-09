package com.azimao.heartbeat.user.pojo.user;

import com.azimao.heartbeat.common.entity.PageParamDTO;
import lombok.Data;

/**
 * @Author: 张隆
 * @Date: 2023/6/21 15:59
 * @Version: 1.0
 */
@Data
public class UserQueryDTO extends PageParamDTO {

    /**
     * 用户openid
     */
    private String openid;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
}
