package com.dtc.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

/**
 * @Description netty服务初始化
 * @author Administrator
 *
 */
public class ServerChannelInitializer extends ChannelInitializer<SocketChannel>{
	@Override
	protected void initChannel(SocketChannel socketChannel) {
		//添加编码
		socketChannel.pipeline().addLast("decoder", new StringDecoder(CharsetUtil.UTF_8));
		socketChannel.pipeline().addLast("encode", new StringEncoder(CharsetUtil.UTF_8));
		socketChannel.pipeline().addLast(new NettyServerHandler());
	}

}
