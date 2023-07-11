package com.azimao.heartbeat.common.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "id条件")
public class CommonIdDTO {

    /**
     * id
     */
    @Schema(description = "ID")
    private Integer id;

}
