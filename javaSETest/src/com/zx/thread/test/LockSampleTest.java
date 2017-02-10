package com.zx.thread.test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * @author xzhu036
 * @createDate 2017年2月9日
 * 用于AB两个线程交替进行
 */
public class LockSampleTest {
	public static void main(String[] args) {
		Ticket ticket=new Ticket();
		new Thread(new FutureTask<>(new GetTicket(ticket)),"AA").start();
		new Thread(new SaveTicket(ticket),"BB").start();
	}
}


class GetTicket implements Callable<Integer>{
	private Ticket ticket;
	
	public GetTicket(Ticket ticket) {
		super();
		this.ticket = ticket;
	}

	@Override
	public Integer call() throws Exception {
		for(int i=0;i<10;i++){
			Thread.sleep(200);
			int counts=ticket.decrement();
			
		}
		return null;
	}
	
}

class SaveTicket implements Runnable{
	private Ticket ticket;
	
	public SaveTicket(Ticket ticket) {
		super();
		this.ticket = ticket;
	}

	@Override
	public void run() {
		for(int i=0;i<10;i++){
//			try {
//				Thread.sleep(200);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			int counts=ticket.increment();
			
		}
	}
	
}



class Ticket{
	
	private Integer ticketCounts;
	Lock lock=new ReentrantLock();
	Condition condition=lock.newCondition();
	
	public void init(){
		ticketCounts=0;//此处写成了定值
	}

	public Ticket() {
		init();
	}
	
	public int increment(){
		lock.lock();
		try{
			while(ticketCounts>0){
				condition.await();
			}
			ticketCounts++;
			System.out.println(Thread.currentThread().getName()+"存入了一张票，余票为"+ticketCounts);
			condition.signalAll();
		}catch (Exception e) {
			// TODO: handle exception
		}finally{
			lock.unlock();
		}
		return ticketCounts;
	}
	
	public int decrement(){
		lock.lock();
		try{
			while(ticketCounts<=0){
				condition.await();
			}
			ticketCounts--;
			System.out.println(Thread.currentThread().getName()+"取到了一张票，余票为"+ticketCounts);
			condition.signalAll();
		}catch (Exception e) {
			// TODO: handle exception
		}finally{
			lock.unlock();
		}
		return ticketCounts;
	}
	
}