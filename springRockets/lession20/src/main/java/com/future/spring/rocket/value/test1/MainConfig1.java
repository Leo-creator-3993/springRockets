package com.future.spring.rocket.value.test1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan
@PropertySource({"classpath:db.properties"})
public class MainConfig1 {
}
