package com.seamew.socketProgramming.socket.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.SocketAddress;

/**
 * ServerSocket 是一个监听器, 可以监听特定 IP:PORT 上的请求
 * 接收到请求后与请求方主机建立连接, 并返回一个代表该连接中本机端点的 Socket 对象
 * 该 Socket 对象中包含
 * 本机端口号 (localPort)
 * 远程主机 IP 地址 (remoteIPAddress)
 * 远程主机端口号 (remotePort)
 */

public class TCPServer
{
    private ServerSocket listener = null;

    public TCPServer() {};

    public TCPServer(SocketAddress endpoint)
    {
        try
        {
            this.listener = new ServerSocket();
            this.listener.bind(endpoint);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public TCPServer(ServerSocket serverSocket)
    {
        this.listener = serverSocket;
    }

    public String receiveMessage()
    {
        if (this.listener == null) return "server is not opened";
        StringBuffer sb = new StringBuffer(64);
        try (InputStream serverIn = this.listener.accept().getInputStream())
        {
            byte[] buffer = new byte[1024];
            int readLen;
            while ((readLen = serverIn.read(buffer)) != -1)
            {
                sb.append(new String(buffer, 0, readLen));
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public void closeSocket()
    {
        if (this.listener != null)
        {
            try
            {
                this.listener.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public ServerSocket getListener()
    {
        return listener;
    }

    public void setListener(ServerSocket listener)
    {
        this.listener = listener;
    }
}
