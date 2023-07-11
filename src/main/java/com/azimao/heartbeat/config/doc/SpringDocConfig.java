package com.azimao.heartbeat.config.doc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: 张隆
 * @Date: 2023/7/7 10:49
 * @Version: 1.0
 */
@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(new Info().title("后端接口文档").version("1.0.0"));
    }

}
