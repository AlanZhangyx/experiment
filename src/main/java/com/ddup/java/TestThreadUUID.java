package com.ddup.java;

import java.util.UUID;

import org.junit.Test;

public class TestThreadUUID {

	@Test
	public void main(){
		while (true) {
			new Thread(new UUIDThread()).start();
		}
	}
	
	private class UUIDThread implements Runnable{
		@Override
		public void run() {
			System.out.println(UUID.randomUUID());
		}
		
	}

}
