package com.kafka.Practice.MovieBooking;

import java.util.ArrayList;
import java.util.List;

public class FacadeBookingLayer {
    public void bookSeats(){
        User user1=new User("ram");
        User user2=new User("shyam");
        SeatService seatService=SeatService.getInstance();
        TheatreRoom theatreRoom1=new TheatreRoom(30,seatService);
        System.out.println(theatreRoom1.selectSeat(user1, new ArrayList<>(List.of("A1","A2"))));
        System.out.println(theatreRoom1.selectSeat(user2, new ArrayList<>(List.of("A1","A2"))));
    }
}
