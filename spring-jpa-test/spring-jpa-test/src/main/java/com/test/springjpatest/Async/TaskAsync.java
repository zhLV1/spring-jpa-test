package com.test.springjpatest.Async;

import java.util.Calendar;
import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
@Component
public class TaskAsync {

	 @Async("mySimpleAsync") 
	public Future<String> task(int i,long current){
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar calendar=Calendar.getInstance();
		long time=calendar.getTimeInMillis()-current;
		System.out.println("第"+i+"个程序 "+time);
		return new AsyncResult<>("Task1 accomplished!");
	}
}
