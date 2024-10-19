package com.future.spring.rocket.post.processor.test1;

public class BeanDefinitionRegistryPersonModel {

    private String name;
    private int age;

    public BeanDefinitionRegistryPersonModel() {

    }

    public BeanDefinitionRegistryPersonModel(String name, int age) {
        this.name = name;
        this.age = age;
    }

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
}
