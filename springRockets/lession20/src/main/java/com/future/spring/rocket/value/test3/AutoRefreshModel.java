package com.future.spring.rocket.value.test3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class AutoRefreshModel {

    @Value("${custom.testField}")
    private String testField;

    public String getTestField() {
        return testField;
    }

    @Override
    public String toString() {
        return String.format("testField:%s", testField);
    }
}
