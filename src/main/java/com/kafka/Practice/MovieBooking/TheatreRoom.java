package com.kafka.Practice.MovieBooking;

import java.util.ArrayList;
import java.util.HashMap;

public class TheatreRoom {
    ArrayList<Seat> seats;
    HashMap<String, Seat> map;
    SeatService seatService;
    TheatreRoom(int seatsCount, SeatService seatService){
        seats=new ArrayList<>();
        map=new HashMap<>();
        this.seatService=seatService;
        constructSeats(seatsCount);
    }
    void constructSeats(int seatsCount){
        int startingCharacter='A';
        int i=1;
        while(i<seatsCount){
            Seat seat=new Seat((char)startingCharacter+""+i%10);
            seats.add(seat);
            map.put(seat.name,seat);
            i++;
            if(i%10==1){
                startingCharacter=startingCharacter+1;
            }
        }
    }

    boolean selectSeat(User user,ArrayList<String> seatsNames){
        ArrayList<String> lockedSeats=new ArrayList<>();
        for(String seatName:seatsNames){

            boolean flag=this.seatService.lockSeat(seatName,user);
            if(!flag){
                release(lockedSeats);
                return false;
            }
            lockedSeats.add(seatName);

        }
        return true;
    }
    void release(ArrayList<String> lockedSeats){
        this.seatService.release(lockedSeats);
    }
    boolean bookSeat(User user,ArrayList<String> seatsNames){
        ArrayList<String> confirmSeats=new ArrayList<>();
        for(String seatName:seatsNames){
            if(map.containsKey(seatName)){
                boolean flag=this.seatService.confirmSeat(seatName,user);
                if(!flag){
                    releaseLockedSeats(confirmSeats);
                    return false;
                }
                 confirmSeats.add(seatName);
            }
            else{
                releaseLockedSeats(confirmSeats);
                return false;
            }
        }
//        db.confirmSeats(seatsNames);
        return true;
    }
    void releaseLockedSeats(ArrayList<String> confirmSeats){
        this.seatService.releaseLockedSeats(confirmSeats);
    }
}
