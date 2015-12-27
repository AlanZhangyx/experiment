package com.ddup.chatroom;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class NewSocketTread implements Runnable {

	private Socket socket;

	public NewSocketTread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {

			InputStream in = socket.getInputStream();

			byte[] buffer = new byte[1024];

			int length = 0;
			while ((length = in.read(buffer)) != -1) {
				String data = new String(buffer, 0, length);
				if (data.equals("exit")) {
					break;
				}
				System.out.println(data);
			}

		} catch (Exception e) {

		} finally {
			try {
				// 当客户端输入某个标示退出时才会执行
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
