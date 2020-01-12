package com.gankki.redis.service.impl;

import com.gankki.redis.service.IRedisOthersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Set;

/**
 * Redis others datatype Controller
 * @author liuhao
 * @date 2020/1/12
 */
@Slf4j
@Service
public class IRedisOthersServiceImpl implements IRedisOthersService {
    @Autowired
    private JedisPool jedisPool;

    @Override
    public Long del(String key) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.del(key);
        jedis.close();
        return result;
    }

    @Override
    public byte[] dump(String key) {
        Jedis jedis = jedisPool.getResource();
        byte[] result = jedis.dump(key);
        jedis.close();
        return result;
    }

    @Override
    public Boolean exists(String key) {
        Jedis jedis = jedisPool.getResource();
        Boolean result = jedis.exists(key);
        jedis.close();
        return result;
    }

    @Override
    public Long expire(String key, int seconds) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.expire(key, seconds);
        jedis.close();
        return result;
    }

    @Override
    public Long expireAt(String key, long unixTime) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.expireAt(key, unixTime);
        jedis.close();
        return result;
    }

    @Override
    public Long pexpire(String key, long milliseconds) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.pexpire(key, milliseconds);
        jedis.close();
        return result;
    }

    @Override
    public Long pexpireAt(String key, long millisecondsTimestamp) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.pexpireAt(key, millisecondsTimestamp);
        jedis.close();
        return result;
    }

    @Override
    public Set<String> keys(String pattern) {
        Jedis jedis = jedisPool.getResource();
        Set<String> result = jedis.keys(pattern);
        jedis.close();
        return result;
    }

    @Override
    public Long move(String key, int dbIndex) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.move(key, dbIndex);
        jedis.close();
        return result;
    }

    @Override
    public Long persist(String key) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.persist(key);
        jedis.close();
        return result;
    }

    @Override
    public Long pttl(String key) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.pttl(key);
        jedis.close();
        return result;
    }

    @Override
    public Long ttl(String key) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.ttl(key);
        jedis.close();
        return result;
    }

    @Override
    public String randomKey() {
        Jedis jedis = jedisPool.getResource();
        String result = jedis.randomKey();
        jedis.close();
        return result;
    }

    @Override
    public String rename(String oldkey, String newkey) {
        Jedis jedis = jedisPool.getResource();
        String result = jedis.rename(oldkey, newkey);
        jedis.close();
        return result;
    }

    @Override
    public Long renamenx(String oldkey, String newkey) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.renamenx(oldkey, newkey);
        jedis.close();
        return result;
    }

    @Override
    public String type(String key) {
        Jedis jedis = jedisPool.getResource();
        String result = jedis.type(key);
        jedis.close();
        return result;
    }
}