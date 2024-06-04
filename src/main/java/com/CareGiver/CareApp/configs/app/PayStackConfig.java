package com.CareGiver.CareApp.configs.app;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class PayStackConfig {

    @Value("${paystack.api.key}")
    private String payStackApiKey;
    @Value("${paystack.base.url}")
    private String payStackBaseUrl;

}
