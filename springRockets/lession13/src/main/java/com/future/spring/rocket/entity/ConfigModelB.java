package com.future.spring.rocket.entity;

public class ConfigModelB {

    private ConfigModelA configModelA;

    public ConfigModelB(ConfigModelA configModelA) {
        this.configModelA = configModelA;
    }

    @Override
    public String toString() {
        return String.format("configModelA:%s", configModelA);
    }
}
