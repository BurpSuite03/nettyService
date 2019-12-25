package com.dtc.client;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @Description 客户端初始化
 * @author Administrator
 *
 */
public class NettyClientInitializer extends ChannelInitializer<SocketChannel>{
    @Override  
	protected void initChannel(SocketChannel socketChannel) {
    	  socketChannel.pipeline().addLast("decoder", new StringDecoder());
    	  socketChannel.pipeline().addLast("encoder", new StringEncoder());
    	  socketChannel.pipeline().addLast(new NettyClientHandler());
      }
}
