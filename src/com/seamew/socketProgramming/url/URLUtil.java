package com.seamew.socketProgramming.url;

import java.io.*;
import java.net.URL;

public class URLUtil
{
    public static void download(URL url, File file)
    {
        try (InputStream in = url.openConnection().getInputStream();
             OutputStream out = new FileOutputStream(file))
        {
            byte[] buffer = new byte[1024 * 1024];
            int readLen;
            while ((readLen = in.read(buffer)) != -1)
            {
                out.write(buffer, 0, readLen);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
