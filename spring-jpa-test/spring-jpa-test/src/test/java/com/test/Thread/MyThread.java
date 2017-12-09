package com.test.Thread;

import java.util.Calendar;

import org.jboss.logging.Cause;

public class MyThread implements Runnable {
	private int i=0; 
	private long current=0;
	
	public MyThread(){}
	public MyThread(int i,long current){
		this.i=i;
		this.current=current;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar calendar=Calendar.getInstance();
		long longtime=calendar.getTimeInMillis()-current;
		System.out.println("当前毫秒："+longtime);
		System.out.println("这是第"+i+"个线程");
		
	}

}
