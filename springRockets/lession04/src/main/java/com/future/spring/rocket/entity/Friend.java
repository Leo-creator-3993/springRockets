package com.future.spring.rocket.entity;

import lombok.Data;

@Data
public class Friend {
    private String nationality;
    public Friend(String nationality) {
        this.nationality = nationality;
    }
}
