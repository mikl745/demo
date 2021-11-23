package com.example.demo;

public class User {
    int age;
    String name;
    public User(String name, int age)
    {
        this.name = name;
        this.age = age;
    }
    int getAge()
    {
        return age;
    }
    String getName()
    {
        return name;
    }
    void setAge(int age)
    {
        this.age = age;
    }
    void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "(" + age + "," + name + ")";
    }
}
