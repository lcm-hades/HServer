package com.game.socket;

public class NIOServer {

    public static void main(String[] args) {
        int port = 56789;
        if (args != null && args.length > 0){
            port = Integer.valueOf(args[0]);
        }
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
        new Thread(timeServer, "nio").start();
    }
}
