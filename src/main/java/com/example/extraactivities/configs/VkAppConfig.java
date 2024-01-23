package com.example.extraactivities.configs;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "vk.auth")
@Data
public class VkAppConfig {
    private Integer appId;
    private String accessToken;
}
