package com.future.spring.rocket.aop.extend.model;

public class FoundService {

    private double balance;
    private String name;

    public FoundService() {

    }

    public FoundService(double balance, String name) {
        this.balance = balance;
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void deposit(String name, double cash) {
        System.out.println("用户 ==> " + name + ", 存款 ==> " + cash + "元!");
        balance += cash;
    }

    public void withdrawal(String name, double cash) {
        if(balance < cash) {
            throw new IllegalStateException("余额不足!");
        }
        System.out.println("用户 ==> " + name + ", 取款 ==> " + cash + "元!");
        balance -= cash;
    }

    //获取余额
    public double getBalance(String userName) {
        System.out.println("用户 ==> " + userName + " 正获取余额!");
        return balance;
    }
}
