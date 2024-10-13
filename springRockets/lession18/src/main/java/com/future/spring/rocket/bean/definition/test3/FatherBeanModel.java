package com.future.spring.rocket.bean.definition.test3;

public class FatherBeanModel {
    private String name;
    private int age;
    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return String.format("name:%s, age:%s, desc:%s", name, age, desc);
    }
}
