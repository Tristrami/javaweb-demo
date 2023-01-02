package com.seamew.io.stream;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;

public class StreamUtil
{
    //字节流
    public static byte[] getBytes(File file)
    {
        ArrayList<Byte> temp = new ArrayList<>();
        byte[] bytes = null;
        try (InputStream in = new FileInputStream(file))
        {
            byte[] buf = new byte[1024 * 1024];
            int readLen;
            while ((readLen = in.read(buf)) != -1)
            {
                for (int i = 0; i < readLen; i++)
                    temp.add(buf[i]);
            }
            bytes = new byte[temp.size()];
            for (int i = 0; i < temp.size(); i++)
            {
                bytes[i] = temp.get(i);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return bytes;
    }

    //字符流
    public static String getString(File file)
    {
        StringBuffer sb = new StringBuffer(64);
        try (Reader reader = new FileReader(file))
        {
            int readLen;
            char[] buf = new char[512 * 1024];
            while ((readLen = reader.read(buf)) != -1)
            {
                sb.append(buf, 0, readLen);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return sb.toString();
    }

    //字符流
    public static void write(String content, File file, boolean append)
    {
        try (Writer writer = new FileWriter(file, append))
        {
            writer.write(content);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void copyFile(File origin, File newFile)
    {
        try (InputStream in = new FileInputStream(origin);
             OutputStream out = new FileOutputStream(newFile))
        {
            byte[] buf = new byte[1024 * 1024];
            int readLen;
            while ((readLen = in.read(buf)) != -1)
            {
                out.write(buf, 0, readLen);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    //序列化
    public static <T> void serialize(T t, File f)
    {
        try (OutputStream fileOut = new FileOutputStream(f);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut))
        {
            objectOut.writeObject(t);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    //反序列化
    public static <T> T deserialize(File f)
    {
        T t = null;
        try (InputStream fileIn = new FileInputStream(f);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn))
        {
            t = (T) objectIn.readObject();
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return t;
    }

    // 将对象序列化到字节数组中
    private static <T> byte[] getObjectBytes(T t)
    {
        byte[] bytes = null;
        try (ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
             ObjectOutputStream objectOut = new ObjectOutputStream(byteOut))
        {
            objectOut.writeObject(t);
            bytes = byteOut.toByteArray();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return bytes;
    }

    // 将对象从字节数组中反序列化
    private static <T> T convertBytesToObject(byte[] bytes)
    {
        T t = null;
        try (ByteArrayInputStream byteIn = new ByteArrayInputStream(bytes);
             ObjectInputStream objectIn = new ObjectInputStream(byteIn))
        {
            t = (T) objectIn.readObject();
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return t;
    }

    // 先将对象序列化再反序列化实现深拷贝
    public static <T> T deepClone(T t)
    {
        return convertBytesToObject(getObjectBytes(t));
    }
}
