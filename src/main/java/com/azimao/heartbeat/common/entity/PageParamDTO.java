package com.azimao.heartbeat.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "分页条件")
public class PageParamDTO {

    @ApiModelProperty(value = "页码", required = true)
    private int pageNum = 1;

    @ApiModelProperty(value = "分页大小", required = true)
    private int pageSize = 10;

}
