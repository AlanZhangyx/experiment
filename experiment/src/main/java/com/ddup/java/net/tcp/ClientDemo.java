package com.ddup.java.net.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ClientDemo {

	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("192.168.0.105", 10001);
		
		OutputStream out = socket.getOutputStream();
		out.write("史各庄".getBytes());
		
		socket.close();
	}

}
