package com.ddup.java.net.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(10001);
		
		Socket socket = server.accept();
		
		InputStream input = socket.getInputStream();
		
		byte[] buffer = new byte[1024];
		
		int len = 0;
		
		while ((len = input.read(buffer))!= -1) {
			String data = new String(buffer, 0, len);
			
			System.out.println(data);
		}
	}
}
