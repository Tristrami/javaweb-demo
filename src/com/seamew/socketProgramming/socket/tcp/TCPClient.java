package com.seamew.socketProgramming.socket.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Socket 对象代表两台主机所建立的连接中的一端, 简单来说就是连接中的一个端点
 * 其中主要包含:
 * 本机端口号 (localPort)
 * 远程主机IP地址 (远程主机即与本机建立连接的主机)
 * 远程主机端口号
 */

public class TCPClient
{
    private Socket clientSocket;
    private SocketAddress serverEndpoint = null;

    public TCPClient() { this.clientSocket = new Socket(); }

    public TCPClient(Socket clientSocket)
    {
        this.clientSocket = clientSocket;
    }

    public boolean sendMessage(String content)
    {
        if (this.serverEndpoint == null) return false;
        try (OutputStream clientOut = clientSocket.getOutputStream())
        {
            clientOut.write(content.getBytes());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return true;
    }

    public void connect(SocketAddress serverEndpoint)
    {
        if (serverEndpoint != null &&
            (this.serverEndpoint == null || !this.serverEndpoint.equals(serverEndpoint)))
        {
            try
            {
                clientSocket.connect(serverEndpoint);
                this.serverEndpoint = serverEndpoint;
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void closeSocket()
    {
        if (this.clientSocket != null)
        {
            try
            {
                this.clientSocket.close();
                this.serverEndpoint = null;
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public Socket getClientSocket()
    {
        return clientSocket;
    }

    public void setClientSocket(Socket socket)
    {
        this.clientSocket = socket;
    }
}
