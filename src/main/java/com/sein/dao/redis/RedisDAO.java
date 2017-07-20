package com.sein.dao.redis;

import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * redis操作类
 */
public class RedisDAO {

    @Autowired
    private JedisPool jedisPool;

    /**
     * 通过key获取值
     * @param key
     * @return
     */
    public String get(String key){
        Jedis jedis = jedisPool.getResource();
        String result = jedis.get(key);
        jedis.close();
        return result;
    }

    /**
     * 设置key-value
     * @param key
     * @param value
     * @return
     */
    public String set(String key,String value){
        Jedis jedis=jedisPool.getResource();
        String result=jedis.set(key,value);
        jedis.close();
        return result;
    }

    /**
     * 根据key删除value
     * @param key
     * @return
     */
    public long del(String key) {
        Jedis jedis = jedisPool.getResource();
        long result = jedis.del(key);
        jedis.close();
        return result;
    }

    /**
     * 哈希算法的获取值
     * @param hkey
     * @param key
     * @return
     */
    public String hget(String hkey, String key) {
        Jedis jedis = jedisPool.getResource();
        String result = jedis.hget(hkey,key);
        jedis.close();
        return result;
    }

    /**
     * 哈希算法的设置值
     * @param hkey
     * @param key
     * @return
     */
    public long hset(String hkey, String key, String value) {
        Jedis jedis = jedisPool.getResource();
        long result = jedis.hset(hkey,key,value);
        jedis.close();
        return result;
    }


    /**
     * 哈希算法的删除值
     * @param hkey
     * @param key
     * @return
     */
    public long hdel(String hkey, String key) {
        Jedis jedis = jedisPool.getResource();
        long result = jedis.hdel(hkey,key);
        jedis.close();
        return result;
    }


    /**
     * 给值+1
     * @param key
     * @return
     */
    public long incr(String key) {
        Jedis jedis = jedisPool.getResource();
        long result = jedis.incr(key);
        jedis.close();
        return result;
    }

    /**
     * 给key设置过期时间
     * @param key
     * @param second
     * @return
     */
    public long expire(String key, int second) {
        Jedis jedis = jedisPool.getResource();
        long result = jedis.expire(key,second);
        jedis.close();
        return result;
    }

    /**
     * 获取剩余过期时间
     * @param key
     * @return
     */
    public long ttl(String key) {
        Jedis jedis = jedisPool.getResource();
        long result = jedis.ttl(key);
        jedis.close();
        return result;
    }

}
