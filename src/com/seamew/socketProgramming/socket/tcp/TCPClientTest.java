package com.seamew.socketProgramming.socket.tcp;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetSocketAddress;

public class TCPClientTest
{
    @Test
    public void testSendMessage() throws IOException, InterruptedException
    {
        TCPClient client = new TCPClient();
        client.connect(new InetSocketAddress(8888));
        if (client.sendMessage("hello server!")) System.out.println("Message send successful!");
        else System.out.println("Message send failed!");
        client.closeSocket();
    }
}
