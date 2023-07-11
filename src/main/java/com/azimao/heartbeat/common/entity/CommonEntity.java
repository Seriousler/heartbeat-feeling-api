package com.azimao.heartbeat.common.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
@Schema(description = "默认创建人/创建时间")
public class CommonEntity {

    @Schema(description = "创建者Id")
    @TableField(value = "CREATE_BY", fill = FieldFill.INSERT)
    private Integer createBy;

    @Schema(description = "创建时间")
    @TableField(value = "CREATE_TIME", fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @Schema(description = "最后修改者Id")
    @TableField(value = "UPDATE_BY", fill = FieldFill.INSERT_UPDATE)
    private Integer updateBy;

    @Schema(description = "最后修改时间")
    @TableField(value = "UPDATE_TIME", fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

}
