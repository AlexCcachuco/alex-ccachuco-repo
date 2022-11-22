package com.bosonit.block5profiles;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Data
@Configuration
@Component
public class AppConfig {

    @Value("${spring.profiles.active}")
    private String name;

    @Value("${bd.url}")
    private String bdInfo;
}
