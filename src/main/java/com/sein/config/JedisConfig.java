package com.sein.config;

import com.sein.dao.redis.RedisDAO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;

@Configuration
public class JedisConfig {

    @Value("${REDIS_HOST}")
    private String REDIS_HOST;

    @Value("${REDIS_PORT}")
    private Integer REDIS_PORT;


    @Bean
    public JedisPool getJedisPool(){
        JedisPool jedisPool=new JedisPool(REDIS_HOST,REDIS_PORT);
        return jedisPool;
    }

    @Bean
    public RedisDAO getRedisDao(){
        RedisDAO redisDao=new RedisDAO();
        return redisDao;
    }

}
