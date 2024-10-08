package com.future.spring.rocket.config;

import com.future.spring.rocket.config.env.DevConfig;
import com.future.spring.rocket.config.env.PrdConfig;
import com.future.spring.rocket.config.env.TestConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DevConfig.class, TestConfig.class, PrdConfig.class})
public class EnvMainConfig {
}
