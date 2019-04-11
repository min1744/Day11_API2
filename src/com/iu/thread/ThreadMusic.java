package com.iu.thread;

public class ThreadMusic implements Runnable {
	private int ticket = 10;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.music();
	}
	
	private synchronized void buyTicket() {
		ticket--;
		if(ticket <= 0) {
			System.out.println("매진");
		}else {
			System.out.println(Thread.currentThread().getName() + "님이 들어오셨습니다.");
			System.out.println("Ticket : " + ticket);
		}
	}
	
	public void music() {
		for(int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName());
			System.out.println("비트주세요");
			buyTicket();
		}
	}
}