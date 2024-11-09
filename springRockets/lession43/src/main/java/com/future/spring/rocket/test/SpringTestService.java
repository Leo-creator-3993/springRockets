package com.future.spring.rocket.test;

import org.springframework.stereotype.Service;

@Service
public class SpringTestService {

    public String name() {
        return "foo";
    }

    public int age() {
        return 18;
    }
}
