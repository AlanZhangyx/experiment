package com.ddup.chatroom;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class RoomServer {
	
	private static int SERVER_PORT_INDEX = 10001;
	
	/**
	 * 递增端口，获得一个可用的ServerSocket
	 * @return
	 */
	private static synchronized ServerSocket getNewServer(){
		
		ServerSocket server = null;
		while (server == null && SERVER_PORT_INDEX <20000) {
			try {
				server = new ServerSocket(SERVER_PORT_INDEX);
			} catch (IOException e) {
				System.out.println(SERVER_PORT_INDEX);
				SERVER_PORT_INDEX ++;
			}
		}
		return server;
	}

	/**
	 * 
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws IOException{
		ServerSocket ss = new ServerSocket(Integer.valueOf(args[0]));
		while (true) {
			Socket socket = ss.accept();
			new Thread(new NewSocketTread(socket)).start();
		}
	}
}
