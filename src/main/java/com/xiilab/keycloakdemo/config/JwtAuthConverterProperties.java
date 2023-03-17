package com.xiilab.keycloakdemo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import javax.validation.constraints.NotBlank;

@Data
@Configuration
@ConfigurationProperties(prefix = "jwt.auth.converter")
public class JwtAuthConverterProperties {

    @NotBlank
    private String resourceId;
    private String principalAttribute;
}
