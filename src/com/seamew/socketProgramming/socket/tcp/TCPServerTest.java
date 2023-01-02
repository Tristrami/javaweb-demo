package com.seamew.socketProgramming.socket.tcp;

import org.junit.jupiter.api.Test;

import java.net.InetSocketAddress;

public class TCPServerTest
{
    @Test
    public void testReceiveMessage()
    {
        TCPServer server = new TCPServer(new InetSocketAddress(8888));
        String msg = server.receiveMessage();
        System.out.println(msg);
    }
}
