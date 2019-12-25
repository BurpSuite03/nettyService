package com.dtc.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ServerChannel;

/**
 * netty 服务端处理器
 * @author Administrator
 * 
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter{
	protected final Logger logger = LoggerFactory.getLogger(NettyServerHandler.class);
	
	/**
	 * @Description 客户端连接会触发
	 */
	@Override
	public void channelActive(ChannelHandlerContext ctx) {
		logger.info("Channel active.....");
	}
	
	/**
	 * @Description 客户端发消息会触发
	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		logger.info("服务器收到消息：{}", msg.toString());
		ctx.write("你妹的，敢发消息？");
		ctx.flush();
	}
	
	/**
	 * @Description 发生异常触发
	 */
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}
        
}
