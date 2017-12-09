package com.test.Thread;

import java.util.Calendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestMain {

	public static void main(String[] args) {
		// 线程最大并发数！
		 ExecutorService fixedThreadPool = Executors.newFixedThreadPool(1);
		 Calendar calendar=Calendar.getInstance();
		long current=calendar.getTimeInMillis();
		 System.out.println("当前毫秒："+current);
		 for(int i=1;i<101;i++){
			 fixedThreadPool.execute(new MyThread(i,current));
		 }
		
	}

}
