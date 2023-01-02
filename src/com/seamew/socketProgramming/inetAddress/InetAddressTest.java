package com.seamew.socketProgramming.inetAddress;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;

public class InetAddressTest
{
    public static void main(String[] args) throws UnknownHostException
    {
        // 通过主机名获取ip地址
        InetAddress[] addresses = InetAddress.getAllByName("www.baidu.com");
        System.out.println(Arrays.toString(addresses));

        //通过字节数组获取ip地址
        InetAddress address = InetAddress.getByAddress(new byte[]{127, 0, 0, 1});
        System.out.println("address = " + address);


    }
}
