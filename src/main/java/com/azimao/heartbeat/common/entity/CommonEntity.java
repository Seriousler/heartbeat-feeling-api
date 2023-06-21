package com.azimao.heartbeat.common.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class CommonEntity {

    @ApiModelProperty("创建者Id")
    @TableField(value = "CREATE_BY", fill = FieldFill.INSERT)
    private Integer createBy;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "CREATE_TIME", fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty("最后修改者Id")
    @TableField(value = "UPDATE_BY", fill = FieldFill.INSERT_UPDATE)
    private Integer updateBy;

    @ApiModelProperty("最后修改时间")
    @TableField(value = "UPDATE_TIME", fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

}
