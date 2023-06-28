package com.azimao.heartbeat.lovestandard.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author: 张隆
 * @Date: 2023/6/28 14:09
 * @Version: 1.0
 */
@Data
@TableName("hf_love_standard")
public class LoveStandard {

    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 恋爱标准类型
     */
    private String type;
    /**
     * 恋爱标准
     */
    private String loveStandard;

}
