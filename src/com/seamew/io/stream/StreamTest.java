package com.seamew.io.stream;

import com.seamew.io.entity.Backpack;
import com.seamew.io.entity.User;
import com.seamew.io.stream.StreamUtil;

import java.io.File;

public class StreamTest
{
    public static void main(String[] args)
    {
        File file = new File("/Users/mac/VScode/Java/Files/a.txt");
        User user1 = new User("William", 30);
        user1.setBackpack(new Backpack("water"));
        User user2 = StreamUtil.deepClone(user1);
        user2.setName("Andy");
        user2.setAge(21);
        user2.setBackpack(new Backpack("snack"));
        System.out.println(user1);
        System.out.println(user2);
    }
}
