package com.kelvin.dockerdemo.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPool {
//    private static final String HOST = "127.0.0.1";
    private static final String HOST = "redis";

    private static final int PORT = 6379;

    private static final Integer MAX_TOTAL = 50;

    private static final Integer MAX_IDLE = 50;

    private static final Integer MAX_WAIT_MILLIS = 10000;

    private static final Boolean TEST_ON_BORROW = false;

    private static JedisPool jedisPool;

    static {
        try {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(MAX_TOTAL);
            config.setMaxIdle(MAX_IDLE);
            config.setMaxWaitMillis(MAX_WAIT_MILLIS);
            config.setTestOnBorrow(TEST_ON_BORROW);
            jedisPool = new JedisPool(config, HOST, PORT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized static Jedis getJedis() {
        try {
            return jedisPool.getResource();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void releaseResource() {
        try {
            jedisPool.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
