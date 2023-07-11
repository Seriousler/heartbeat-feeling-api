package com.azimao.heartbeat.common.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "分页条件")
public class PageParamDTO {

    @Schema(description = "页码")
    private int pageNum = 1;

    @Schema(description = "分页大小")
    private int pageSize = 10;

}
