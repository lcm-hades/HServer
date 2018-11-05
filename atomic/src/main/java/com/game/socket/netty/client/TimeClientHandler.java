package com.game.socket.netty.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class TimeClientHandler extends ChannelInboundHandlerAdapter {
    private int counter;
    byte[] req;
    public TimeClientHandler(){
        req = ("QUERY TIME ORDER" + System.getProperty("line.separator")).getBytes();

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        ByteBuf firstMessage;
        for (int i=0; i<100; i++){
            firstMessage = Unpooled.buffer(req.length);
            firstMessage.writeBytes(req);
            ctx.writeAndFlush(firstMessage);
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
//        ByteBuf buf = (ByteBuf) msg;
//        byte[] req = new byte[buf.readableBytes()];
//        buf.readBytes(req);
//        String body = new String(req, "UTF-8");
        String body = (String) msg;
        System.out.println("Now is : " + body + " counter is " + ++counter);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
