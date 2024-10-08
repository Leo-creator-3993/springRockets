package com.future.spring.rocket.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class User {
    private String name;
    private int age;
    private Car car;
    private List<Friend> friendList;
    private Map<String, Integer> habits;
    private Set<String> roles;

    @Override
    public String toString() {
        return String.format("User name:%s, age:%s, car:%s, friendList:%s, habits:%s, roles:%s", name, age, car, friendList, habits, roles);
    }
}
