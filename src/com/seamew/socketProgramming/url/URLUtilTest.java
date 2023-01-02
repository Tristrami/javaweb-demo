package com.seamew.socketProgramming.url;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class URLUtilTest
{
    @Test
    public void testDownload() throws MalformedURLException
    {
        File file = new File("/Users/mac/VScode/Java/General/Practice/JavaWebPractice/SocketPractice/download/qq.exe");
        URL url = new URL("https://im.qq.com/macqq/");
        URLUtil.download(url, file);
    }
}
