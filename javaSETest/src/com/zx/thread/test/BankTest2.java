package com.zx.thread.test;

public class BankTest2 {
	public static void main(String[] args) {
		
		new Thread(new BankThread2("����",0,200)).start();
		new Thread(new BankThread2("����",1,200)).start();
		new Thread(new BankThread2("����",1,200)).start();
	}
}

class Account2{
	private int account=1000;

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}
	
	public void addAccount(int money){
		this.account+=money;
	}
	public void decreaseAcount(int money){
		this.account-=money;
	}
}

class BankThread2 implements Runnable{
	private String name;
	private int method;//0Ϊ��Ǯ��1ΪȡǮ
	private static Account2 account=new Account2();
	private int money;
	
	public BankThread2(String name,int method,  int money) {
		super();
		this.name=name;
		this.method = method;
		this.money=money;
	}

	public BankThread2() {
		super();
	}


	@Override
	public void run() {
		
			if(method==0){
				saveMoney();
			}else if(method==1){
				getMoney();
			}
		
	}
	
	public void saveMoney(){
		synchronized (account) {
			account.addAccount(money);
			System.out.println(name+"������"+money+"�����"+account.getAccount());
			account.notify();
		}
	}
	
	public void getMoney(){
		synchronized (account) {
			if(account.getAccount()>=money){
				account.decreaseAcount(money);
				System.out.println(name+"ȡ����"+money+"�����"+account.getAccount());
			}else{
				System.out.println(name+"���㣡");
			}
			account.notify();
		}
	}
	
}