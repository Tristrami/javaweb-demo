package com.seamew.io.entity;

import java.io.Serial;
import java.io.Serializable;

public class User implements Serializable
{
    @Serial
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private Backpack backpack;

    public User(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public User() {}

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public Backpack getBackpack()
    {
        return backpack;
    }

    public void setBackpack(Backpack backpack)
    {
        this.backpack = backpack;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", backpack=" + backpack +
                '}';
    }
}
