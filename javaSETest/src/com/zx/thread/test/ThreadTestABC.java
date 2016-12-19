package com.zx.thread.test;

import java.util.concurrent.SynchronousQueue;

public class ThreadTestABC {
	public static void main(String[] args) throws InterruptedException {
		ABCThread a=new ABCThread("A");
		ABCThread b=new ABCThread("B");
		ABCThread c=new ABCThread("C");
		a.setPrev(c);
		b.setPrev(a);
		c.setPrev(b);
		new Thread(a).start();
		Thread.sleep(100);
		new Thread(b).start();
		Thread.sleep(100);
		new Thread(c).start();
	}
}

class ABCThread implements Runnable{
	private String name;
	private Object prev;
	
	
	public ABCThread(String name) {
		super();
		this.name = name;
	}

	public void setPrev(Object prev) {
		this.prev = prev;
	}

	public ABCThread() {
		super();
	}

	@Override
	public void run() {
		int i=0;
		while(i<10){
			i++;
			synchronized (prev) {
				synchronized (this) {
					System.out.print(name);
					this.notify();
				}
				try {
					prev.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.exit(0);
	}
	
}
