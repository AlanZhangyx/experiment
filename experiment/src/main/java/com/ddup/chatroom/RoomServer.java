package com.ddup.chatroom;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class RoomServer {

	public static void main(String[] args) throws IOException {
		InetAddress bindAddr = InetAddress.getLocalHost();
		ServerSocket server = new ServerSocket(20161, 100, bindAddr);
		Socket socket = server.accept();
		InputStream input = socket.getInputStream();
		byte[] buffer = new byte[1024];
		int number = 0;
		while( (number = input.read(buffer)) > 0){
		}
		
		/*
		InputStream input = new InputStream();
		os.write(b, off, len);*/
		
	}

}
