package com.kafka.Practice.MovieBooking;
import redis.clients.jedis.Jedis;

public class RedisClient {
    public static Jedis getConnection(){
        return new Jedis("localhost", 6379);
    }
}
