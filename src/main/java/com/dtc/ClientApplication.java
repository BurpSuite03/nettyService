package com.dtc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dtc.client.NettyClient;

@SpringBootApplication
public class ClientApplication {
    public static void main(String args[]) {
    	SpringApplication.run(ClientApplication.class, args);
    	
    	//启动客户端
    	NettyClient nettyClient = new NettyClient();
    	nettyClient.start();
    }
}
