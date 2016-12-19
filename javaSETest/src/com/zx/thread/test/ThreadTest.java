package com.zx.thread.test;

public class ThreadTest {
	public static void main(String[] args) {
		Thread1 t1=new Thread1();
		Thread t2=new Thread(new Thread2());//由于Runnable没有start方法，所以需要创建Thread对象来开启线程
		t1.start();//调用start方法后，系统会自动分析并开启一个新的线程，并不一定是刚start就执行
		t2.start();
		//t1.run();//run方法的调用相当于直接主线程中调用，因为没起新的线程，所以是单向的，run方法执行完才会执行下面代码
	}
}
class Thread1 extends Thread{
	@Override
	public synchronized void run() {
		int a=1;
		while(true){
			System.out.println(a);
			a+=2;
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(a>10){
				break;
			}
		}
	}
}

class Thread2 implements Runnable{

	@Override
	public synchronized void run() {
		int a=2;
		while(true){
			try {
				System.out.println(a);
				a+=2;
				//Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(a>10){
				break;
			}
		}
	}
	
}