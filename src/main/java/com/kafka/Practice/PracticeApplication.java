package com.kafka.Practice;

import com.kafka.Practice.BankManagement.BankManager;
import com.kafka.Practice.BankManagement.Service.AccountService;
import com.kafka.Practice.ChatApplication.ChatWorkingLayer;
import com.kafka.Practice.MovieBooking.FacadeBookingLayer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PracticeApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(PracticeApplication.class, args);
//		FacadeBookingLayer facadeBookingLayer=new FacadeBookingLayer();
//		facadeBookingLayer.bookSeats();
//		AccountService accountService=new AccountService();
//		BankManager bankManager=new BankManager(accountService);
//		bankManager.mainn();
		ChatWorkingLayer chatWorkingLayer=new ChatWorkingLayer();
		chatWorkingLayer.start();
	}
}
