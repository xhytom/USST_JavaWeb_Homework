package com.test.Entity;

public class UserEntity {
    private String name;
    private Integer age;
    private Integer state;

    public UserEntity(String name, Integer age, Integer state) {
        this.name = name;
        this.age = age;
        this.state = state;
    }

    public UserEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
