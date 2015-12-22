package com.ddup.chatroom;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class RoomServer {

	public static void main(String[] args) throws IOException {
		InetAddress bindAddr = InetAddress.getLocalHost();
		ServerSocket server = new ServerSocket(20161, 100, bindAddr);
		Socket socket = server.accept();
		OutputStream os = socket.getOutputStream();
		
		/*byte[] buffer = new byte[1024];
		InputStream input = new InputStream();
		os.write(b, off, len);*/
	}

}
