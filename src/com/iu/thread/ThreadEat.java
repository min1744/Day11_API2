package com.iu.thread;

public class ThreadEat extends Thread {
	@Override
	public void run() {
		//동시에 진행하고싶은 코드
		eat();
	}
	private void eat() {
		for(int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("촵촵");
		}
	}
}