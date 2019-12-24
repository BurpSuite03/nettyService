package com.dtc.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @Description 客户端处理器
 * @author Administrator
 *
 */
public class NettyClientHandler extends ChannelInboundHandlerAdapter{
	protected final Logger logger = LoggerFactory.getLogger(NettyClientHandler.class);
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) {
		logger.info("client Active......");
	}
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		logger.info("client收到消息：{}", msg.toString());
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}

}
