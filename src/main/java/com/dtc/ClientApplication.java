package com.dtc;

import java.net.InetSocketAddress;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dtc.server.NettyServer;

@SpringBootApplication
public class ClientApplication {
    public static void main(String args[]) {
    	SpringApplication.run(ClientApplication.class, args);
    	
    	//启动服务端
        NettyServer nettyServer = new NettyServer();
        nettyServer.start(new InetSocketAddress("127.0.0.1",8090));
    	
    	/*//启动客户端
    	NettyClient nettyClient = new NettyClient();
    	nettyClient.start();*/
    }
}
