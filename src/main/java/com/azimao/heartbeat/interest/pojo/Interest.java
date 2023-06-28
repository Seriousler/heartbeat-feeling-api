package com.azimao.heartbeat.interest.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @Author: 张隆
 * @Date: 2023/6/28 11:19
 * @Version: 1.0
 */

/**
 * 兴趣爱好
 */
@TableName("hf_interest")
public class Interest {

    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 兴趣爱好类型
     */
    private String type;
    /**
     * 兴趣爱好
     */
    private String interest;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }
}
