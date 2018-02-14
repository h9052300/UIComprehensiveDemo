package com.imooc.ui_basetestdemo_food;

public class Person {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", sex=" + sex + ", food=" + food + "]";
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    private String name;
    private String sex;
    Food food;
}
