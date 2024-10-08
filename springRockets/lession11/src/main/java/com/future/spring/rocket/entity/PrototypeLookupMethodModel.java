package com.future.spring.rocket.entity;

public class PrototypeLookupMethodModel {

    public void talk() {
        PrototypeModel prototypeModel = this.getPrototypeModel();
        System.out.println(this + ", prototypeModel" + prototypeModel);
    }

    public PrototypeModel getPrototypeModel() {
        return null;
    }

}
