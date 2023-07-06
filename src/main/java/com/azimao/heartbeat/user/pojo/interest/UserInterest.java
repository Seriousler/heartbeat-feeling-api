package com.azimao.heartbeat.user.pojo.interest;

import com.azimao.heartbeat.common.entity.CommonEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author: 张隆
 * @Date: 2023/6/21 16:25
 * @Version: 1.0
 */
@Data
@TableName("hf_user_interest")
public class UserInterest extends CommonEntity {

    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 用户openid
     */
    private String openid;
    /**
     * 兴趣爱好
     */
    private String interest;

}
