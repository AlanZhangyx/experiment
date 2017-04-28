package com.ddup.java.net.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ClientCMD {

	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("192.168.0.105", 10001);
		OutputStream out = socket.getOutputStream();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String data = null;
		while ((data = br.readLine())!=null) {
			if (data.equals("exit")) {
				break;
			}
			out.write(data.getBytes());
		}
		System.out.println("客户端要关闭了");
		socket.close();
	}

}
