package com.el.jichu.domain;

/**
 * 交易员类
 */
public class Trader {
    private String name;
    private String city;

    public Long age;
    public Long roId;

    public Long getRoId() {
        return roId;
    }

    public void setRoId(Long roId) {
        this.roId = roId;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public Trader() {
    }

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Trader{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
