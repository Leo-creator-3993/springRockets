package com.future.spring.rocket.jdbctemplate.model;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class DbModel {
    private int id;
    private String name;

    public DbModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public DbModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DbModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
