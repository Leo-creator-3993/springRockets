package com.future.spring.rocket.mybatis.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserModel {
    private Integer id;

    private String name;
}
