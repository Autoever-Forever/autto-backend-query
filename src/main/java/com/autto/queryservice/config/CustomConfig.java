package com.autto.queryservice.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class CustomConfig {
    @Value("${custom.url.reservation}")
    private String reservationUrl;
}
