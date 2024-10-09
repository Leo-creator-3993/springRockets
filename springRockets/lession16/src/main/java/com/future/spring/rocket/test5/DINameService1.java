package com.future.spring.rocket.test5;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("dINameService1")
@Primary
public class DINameService1 implements IDINameService{
}
