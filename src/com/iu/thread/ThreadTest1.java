package com.iu.thread;

public class ThreadTest1 {

	public static void main(String[] args) {
		ThreadEat te = new ThreadEat();
		ThreadTv tv = new ThreadTv();
		ThreadMusic tm = new ThreadMusic();
		Thread t = new Thread(tm, "iu");
		Thread t2 = new Thread(tm, "choa");
		t.start();
		//t2.start();
	}
}