package com.kafka.Practice;

import com.kafka.Practice.MovieBooking.FacadeBookingLayer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);
//		FacadeBookingLayer facadeBookingLayer=new FacadeBookingLayer();
//		facadeBookingLayer.bookSeats();
	}
}
