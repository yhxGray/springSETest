package com.zx.thread.test;

public class BankTest3 {
	public static void main(String[] args) throws InterruptedException {
		SaveMoney a=new SaveMoney("A");
		SaveMoney b=new SaveMoney("B");
		a.setOther(b);
		b.setOther(a);
		new Thread(a).start();
		Thread.sleep(50);
		new Thread(b).start();
	}
}

class SaveMoney implements Runnable{

	private String name;
	private Object other;
	private static Integer money=0;
	
	public SaveMoney(String name) {
		super();
		this.name = name;
	}

	public Object getOther() {
		return other;
	}

	public void setOther(Object other) {
		this.other = other;
	}

	@Override
	public void run() {
		for(int i=0;i<3;i++){
			synchronized (other) {
				synchronized (this) {
					money+=3000;
					System.out.println(name+"´æÈë3000£¬Óà¶î"+money);
					this.notify();
				}
					try {
						other.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}
		}
	}
	
}