package com.ddup.chatroom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class RoomServer {
	
	public static void main(String[] args) throws IOException {
		InetAddress bindAddr = InetAddress.getLocalHost();
		ServerSocket server = new ServerSocket(20161, 100, bindAddr);
		
		while(true){
			// 阻塞监听
			Socket socket = server.accept();
			
			// 读取
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			
			// 存放进String
			StringWriter sw = new StringWriter();
			//存放
			String line = null;
			while ((line = br.readLine()) !=null) {
				
			}
			
		}
		
		
		
		/*byte[] buffer = new byte[1024];
		InputStream input = new InputStream();
		os.write(b, off, len);*/
	}

}
