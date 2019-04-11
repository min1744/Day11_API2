package com.iu.thread;

public class ThreadTv extends Thread {
	@Override
	public void run() {
		//동시에 진행하고싶은 코드
		tv();
	}
	private void tv() {
		for(int i = 0; i < 10; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("TV 보기");
		}
	}
}