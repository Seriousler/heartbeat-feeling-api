package com.azimao.heartbeat.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "id条件")
public class CommonIdDTO {

    /**
     * id
     */
    @ApiModelProperty(value = "ID")
    private Integer id;

}
