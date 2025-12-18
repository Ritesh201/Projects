package com.kafka.Practice.MovieBooking;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;
import redis.clients.jedis.params.SetParams;

import java.util.ArrayList;

public class SeatService {
    private final int LOCK_TTL_SECONDS=120;
    static SeatService instance;
    static SeatService getInstance(){
        if(instance==null){
            instance=new SeatService();
        }
        return instance;
    }

    SetParams setParams=new SetParams().nx().ex(LOCK_TTL_SECONDS);

    public boolean lockSeat(String seatId, User userId) {
        try (Jedis jedis = RedisClient.getConnection()) {
            jedis.set("dd","sd",setParams);
            String seatKey = "seat:" + seatId;
            String lockKey = "lock:seat:" + seatId;

            String seatStatus = jedis.get(seatKey);
            if ("BOOKED".equals(seatStatus)) {
                return false;
            }

            SetParams params = new SetParams()
                    .nx()
                    .ex(LOCK_TTL_SECONDS);

            String lockResult = jedis.set(lockKey, userId.name, params);

            return ("OK".equals(lockResult));
        }
    }
    public boolean confirmSeat(String seatId, User userId) {
        try (Jedis jedis = RedisClient.getConnection()) {

            String seatKey = "seat:" + seatId;
            String lockKey = "lock:seat:" + seatId;
            String userName = jedis.get(lockKey);
            if (!userId.name.equals(userName)) {
                return false;
            }
            Transaction tx = jedis.multi();
            tx.set(seatKey, "BOOKED");
            tx.del(lockKey);
            tx.exec();
            return true;

        }
    }

    public void release(ArrayList<String> lockedSeats) {
        try (Jedis jedis = RedisClient.getConnection()) {

            for (String lockedSeat : lockedSeats) {
                String lockKey = "lock:seat:" + lockedSeat;
                jedis.del(lockKey);
            }
        }

    }

    public void releaseLockedSeats(ArrayList<String> confirmSeats) {
        try (Jedis jedis = RedisClient.getConnection()) {

            for (String seatId : confirmSeats) {
                String seatKey = "seat:" + seatId;
                jedis.del(seatKey);
            }
        }
    }
}
