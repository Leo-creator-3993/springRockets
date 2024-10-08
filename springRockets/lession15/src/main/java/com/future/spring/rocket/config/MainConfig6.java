package com.future.spring.rocket.config;

import com.future.spring.rocket.config.extend.Test2Config;
import com.future.spring.rocket.config.extend.TestConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({TestConfig.class, Test2Config.class})
public class MainConfig6 {
}
