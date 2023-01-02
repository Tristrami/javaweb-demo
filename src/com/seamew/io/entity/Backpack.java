package com.seamew.io.entity;

import java.io.Serial;
import java.io.Serializable;

public class Backpack implements Serializable
{
    @Serial
    private static final long serialVersionUID = 2L;

    private String stuff;

    public Backpack() {}

    public Backpack(String stuff)
    {
        this.stuff = stuff;
    }

    public String getStuff()
    {
        return stuff;
    }

    public void setStuff(String stuff)
    {
        this.stuff = stuff;
    }

    @Override
    public String toString()
    {
        return "Backpack{" +
                "stuff='" + stuff + '\'' +
                '}';
    }
}
