package com.azimao.heartbeat.common.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @Author: 张隆
 * @Date: 2023/6/28 14:34
 * @Version: 1.0
 */
@JsonIgnoreProperties(
        ignoreUnknown = true
)
@Data
public class Account {

    private String token;
    private String openid;
    private Integer userId;
    private String userCode;
    private String userName;
    private String nickName;
    private String phone;
    private String email;
    private int isManager;
    private Integer orgId;
    private String orgCode;
    private String orgName;
    private String roleIds;
    private String roleCodes;
    private String roleNames;

}
