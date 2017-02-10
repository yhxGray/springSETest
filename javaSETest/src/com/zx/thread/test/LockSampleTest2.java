package com.zx.thread.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * @author xzhu036
 * @createDate 2017年2月9日
 * 利用多线程ABC交替循环打印各10次
 */
public class LockSampleTest2 {
	public static void main(String[] args) {
		PrintABC abc=new PrintABC();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<10;i++){
					abc.printA();
				}
			}
		}).start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<10;i++){
					abc.printB();
				}
			}
		}).start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<10;i++){
					abc.printC();
				}
			}
		}).start();
	}
}

class PrintABC{
	Lock lock=new ReentrantLock();
	Condition condition=lock.newCondition();
	String flag="A";
	public void printA(){
		lock.lock();
		try{
			while(!flag.equals("A")){
				condition.await();
			}
			System.out.print("A");
			flag="B";
			condition.signalAll();
		}catch (Exception e) {
			
		}finally{
			lock.unlock();
		}
	}
	
	public void printB(){
		lock.lock();
		try{
			while(!flag.equals("B")){
				condition.await();
			}
			System.out.print("B");
			flag="C";
			condition.signalAll();
		}catch (Exception e) {
			
		}finally{
			lock.unlock();
		}
	}
	
	public void printC(){
		lock.lock();
		try{
			while(!flag.equals("C")){
				condition.await();
			}
			System.out.print("C");
			flag="A";
			condition.signalAll();
		}catch (Exception e) {
			
		}finally{
			lock.unlock();
		}
	}
}
