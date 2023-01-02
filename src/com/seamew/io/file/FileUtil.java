package com.seamew.io.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FileUtil
{
    public static List<File> listAll(File file, String suffix)
    {
        Stack<File> s = new Stack<>();
        List<File> correspondingFiles = new ArrayList<>();
        s.push(file);
        while (!s.empty())
        {
            File curFile = s.peek();
            s.pop();
            File[] files = curFile.listFiles();
            if (files != null && files.length != 0)
            {
                for (File f : files)
                {
                    if (f.isDirectory()) s.push(f);
                    else if (f.getName().endsWith(suffix)) correspondingFiles.add(f);
                }
            }
        }
        return correspondingFiles;
    }
}
