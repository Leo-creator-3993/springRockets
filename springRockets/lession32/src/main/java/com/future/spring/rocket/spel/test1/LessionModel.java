package com.future.spring.rocket.spel.test1;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LessionModel {

    @Value("hello, %{name}, %{msg}")
    private String desc;

    @Override
    public String toString() {
        return "LessionModel{" +
                "desc='" + desc + '\'' +
                '}';
    }
}
