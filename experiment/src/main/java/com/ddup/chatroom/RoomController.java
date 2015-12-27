package com.ddup.chatroom;

import java.io.IOException;

public class RoomController {

	public static void main(String[] args) throws IOException {
		args = new String[]{"10001"};
		RoomServer.main(args);
		
		args = new String[]{"10002"};
		RoomServer.main(args);
	}

}
