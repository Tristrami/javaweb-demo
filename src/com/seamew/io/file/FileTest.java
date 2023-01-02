package com.seamew.io.file;

import java.io.File;
import java.util.List;

public class FileTest
{
    public static void main(String[] args)
    {
        File file = new File("/Users/mac/VScode/Java/Files");
        List<File> files = FileUtil.listAll(file, ".txt");
        for (File f : files)
        {
            System.out.println("Name: " + f.getName() + " Path: " + f.getAbsolutePath());
        }
    }
}
