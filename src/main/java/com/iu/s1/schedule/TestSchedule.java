package com.iu.s1.schedule;

import java.util.Calendar;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestSchedule {

	//@Scheduled(fixedRate = 1000)	//1초 마다 반복
	//@Scheduled(fixedRateString = "1000")
	
	//@Scheduled(fixedDelay = 1000)
	public void delay() throws Exception{
		System.out.println("fixDelay");
		System.out.println(Thread.currentThread().getName());
		System.out.println(Calendar.getInstance().getTime());
		Random random = new Random();
		int d = random.nextInt(3000)+1000;
		Thread.sleep(d);
	}
	
	//@Scheduled(fixedRate = 1000)
	public void rate() throws Exception{
		System.out.println("rate");
		System.out.println(Thread.currentThread().getName());
		System.out.println(Calendar.getInstance().getTime());
		Random random = new Random();
		int d = random.nextInt(3000)+1000;
		Thread.sleep(d);
	}
	
	//@Scheduled(cron = "10 * * * * *")
	public void cronSchedule() throws Exception{
		Calendar ca = Calendar.getInstance();
		System.out.println(ca.getTime());
		System.out.println("매분 10초에 실행");
	}
	
}
