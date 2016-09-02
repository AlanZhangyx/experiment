package com.ddup.research;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class RpcFramework {

    
    /**
     * 绑定端口提供ServerSocket。
     * 监听端口，如果有Socket连接上，就将对象写给Socket；
     * @param service
     * @param port
     */
    public void export(final Object service, int port){
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try {
            // 监听端口，如果接受到客户端，就在客户端的输出流中输出对象
            Socket client = server.accept();
            // 客户端连接的时候，需要告诉我们它需要的OBJ。所以我们要读取client的input
            ObjectInputStream input = new ObjectInputStream(client.getInputStream());
            
            
//            client.getOutputStream().write(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    
}
