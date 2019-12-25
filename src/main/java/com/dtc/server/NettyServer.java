package com.dtc.server;

import java.net.InetSocketAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyServer {
	protected final Logger logger = LoggerFactory.getLogger(NettyServer.class);
	
	public void start(InetSocketAddress inetSocketAddress) {
		//创建一个主线程
		EventLoopGroup bossGroup = new NioEventLoopGroup(1);
		//创建一个工作线程组
		EventLoopGroup workGroup = new NioEventLoopGroup(200);
	    
		ServerBootstrap bootstrap = new ServerBootstrap().group(bossGroup,workGroup)
				.channel(NioServerSocketChannel.class)
				.childHandler(new ServerChannelInitializer())
				.localAddress(inetSocketAddress)
				//设置队列大小
				.option(ChannelOption.SO_BACKLOG, 1024)
				//两个小时内没有数据的通信时，TCP会自动发送一个活动的探测报文
				.childOption(ChannelOption.SO_KEEPALIVE, true);
		        
		         try {
					ChannelFuture future = bootstrap.bind(inetSocketAddress).sync();
					logger.info("服务器启动开始监听端口：{}", inetSocketAddress.getPort());
					future.channel().closeFuture().sync();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally {					
					//关闭主线程
					bossGroup.shutdownGracefully();
					//关闭工作线程
					workGroup.shutdownGracefully();
				}           
	}

}
