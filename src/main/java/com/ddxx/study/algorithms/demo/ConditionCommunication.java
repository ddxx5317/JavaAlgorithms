package com.ddxx.study.algorithms.demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionCommunication {
	public static void main(String[] args) {
		final MyThread myThread = new MyThread();
		new Thread(()->{
			for (int i = 1; i <= 5; i++) {
				myThread.print1(i);
			}
		},"t1").start();

		new Thread(()->{
			for (int i = 1; i <= 5; i++) {
				myThread.print2(i);
			}
		},"t2").start();

	}
	static class MyThread {
		Lock lock = new ReentrantLock();
		Condition condition = lock.newCondition();
		private volatile boolean flag = true;
		public void print1(int i) {
			lock.lock();
			try {
				while (!flag) {
					condition.await();
				}
				for (int j = 1; j <= 5; j++) {
					System.out.println(Thread.currentThread().getName()+"->" + j + ",loop of " + i);
				}
				flag = false;
				condition.signal();
			}  catch (Exception e) {
				e.printStackTrace();
			}finally {
				lock.unlock();
			}
		}
		public void print2(int i) {
			lock.lock();
			try {
				while (flag) {
					condition.await();
				}
				for (int j = 1; j <= 5; j++) {
					System.out.println(Thread.currentThread().getName()+"->" + j + ",loop of " + i);
				}
				flag = true;
				condition.signal();
			} catch (Exception e){
				e.printStackTrace();
			}finally {
				lock.unlock();
			}
		}
	}
}
