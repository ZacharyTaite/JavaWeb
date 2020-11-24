package com.teamsun.transfer2.threadlocal;

public class TestThreadLocal {
	public static void main(String[] args) {
		ThreadLocal tl = new ThreadLocal();
		tl.set("p");
		
		MyThread mt = new MyThread(tl);
		mt.start();
		
		System.out.println("t1:"+tl.get());
	}
}
