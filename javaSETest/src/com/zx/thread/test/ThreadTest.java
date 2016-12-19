package com.zx.thread.test;

public class ThreadTest {
	public static void main(String[] args) {
		Thread1 t1=new Thread1();
		Thread t2=new Thread(new Thread2());//����Runnableû��start������������Ҫ����Thread�����������߳�
		t1.start();//����start������ϵͳ���Զ�����������һ���µ��̣߳�����һ���Ǹ�start��ִ��
		t2.start();
		//t1.run();//run�����ĵ����൱��ֱ�����߳��е��ã���Ϊû���µ��̣߳������ǵ���ģ�run����ִ����Ż�ִ���������
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