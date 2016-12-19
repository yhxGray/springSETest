package com.zx.thread.test;

public class BankTest {
	public static void main(String[] args) throws InterruptedException {
		Account a=new Account();
		Thread t1=new Thread(new GetThread(a));
		Thread t2=new Thread(new SaveThread(a));
		Thread t3=new Thread(new SaveThread(a));
		t1.setName("����");
		t2.setName("����");
		t3.setName("����");
		t1.start();
		t2.start();
		t3.start();
	}
}

class Account{
	private int account=0;
	private boolean flag=false;
		

	public int getAccount() {
		return account;
	}

	public synchronized void getMoney(int money) {
		try{
			if(!flag){
				wait();
			}else{
				if(account>=money){
					account-=money;
					System.out.println(Thread.currentThread().getName()+"ȡ��"+money+"�����"+account);
				}else{
					System.out.println(Thread.currentThread().getName()+"����");
				}
				flag=false;
				notify();
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
	}
	
	public synchronized void saveMoney(int money) {
		try{
			if(flag){
				wait();
			}else{
				account+=money;
				System.out.println(Thread.currentThread().getName()+"����"+money+"�����"+account);
				flag=true;
				notifyAll();
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
	}
}

class GetThread implements Runnable{
	Account account;
	
	public GetThread(Account account) {
		super();
		this.account = account;
	}

	@Override
	public void run() {
		int i=0;
		while(i<12){
			account.getMoney(1000);
			i++;
		}
	}
}

class SaveThread implements Runnable{
	Account account;
	
	public SaveThread(Account account) {
		super();
		this.account = account;
	}

	@Override
	public void run() {
		int i=0;
		while(i<7){
			account.saveMoney(1000);
			i++;
		}
	}
}
