package com.dtc.netty.controller;

import java.util.Scanner;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dtc.client.NettyClientInitializer;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="netty",tags="netty")
@RestController
@RequestMapping("netty")
public class NettyController {
	@GetMapping("/parameter")
	@ApiOperation(value="用户端发送数据")
	public void clientStart(@RequestParam(name="parameter",required=true)String parameter) {
		 EventLoopGroup group = new NioEventLoopGroup();
		   Bootstrap bootstrap = new Bootstrap().group(group)
				   //该参数的作用就是禁止使用Nagle算法，使用于小数据即时传输
				   .option(ChannelOption.TCP_NODELAY, true)
				   .channel(NioSocketChannel.class)
				   .handler(new NettyClientInitializer());
				   
		           try {
					ChannelFuture future = bootstrap.connect("127.0.0.1", 8090).sync();
					//发送消息
					future.channel().writeAndFlush(parameter);
					//等待连接被关闭
					future.channel().closeFuture().sync();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally {
					group.shutdownGracefully();
				}
	}

}
