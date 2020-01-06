package com.gankki.redis.service.impl;

import com.gankki.redis.service.IRedisStringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

/**
 * Redis String datatype ServiceImpl
 * @author liuhao
 * @date 2019/12/1
 */
@Service
public class RedisStringServiceImpl implements IRedisStringService {
    @Autowired
    private JedisPool jedisPool;

    @Override
    public String set(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        String result = jedis.set(key, value);
        jedis.close();
        return result;
    }

    @Override
    public String set(String key, String value, int liveTime) {
        Jedis jedis = jedisPool.getResource();
        String result = jedis.set(key, value);
        jedis.expire(key, liveTime);
        jedis.close();
        return result;
    }

    @Override
    public String get(String key) {
        Jedis jedis = jedisPool.getResource();
        String result = jedis.get(key);
        jedis.close();
        return result;
    }

    @Override
    public String getRange(String key, long startOffset, long endOffset) {
        Jedis jedis = jedisPool.getResource();
        String result = jedis.getrange(key, startOffset, endOffset);
        jedis.close();
        return result;
    }

    @Override
    public String getSet(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        String result = jedis.getSet(key, value);
        jedis.close();
        return result;
    }

    @Override
    public Boolean setbit(String key, long offset, String value) {
        Jedis jedis = jedisPool.getResource();
        Boolean result = jedis.setbit(key, offset, value);
        jedis.close();
        return result;
    }

    @Override
    public Boolean getbit(String key, long offset) {
        Jedis jedis = jedisPool.getResource();
        Boolean result = jedis.getbit(key, offset);
        jedis.close();
        return result;
    }

    @Override
    public List<String> mget(String... keys) {
        Jedis jedis = jedisPool.getResource();
        List<String> result = jedis.mget(keys);
        jedis.close();
        return result;
    }

    @Override
    public String setex(String key, int seconds, String value) {
        Jedis jedis = jedisPool.getResource();
        String result = jedis.setex(key, seconds, value);
        jedis.close();
        return result;
    }

    @Override
    public Long setnx(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.setnx(key, value);
        jedis.close();
        return result;
    }

    @Override
    public Long setrange(String key, long offset, String value) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.setrange(key, offset, value);
        jedis.close();
        return result;
    }

    @Override
    public Long strlen(String key) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.strlen(key);
        jedis.close();
        return result;
    }

    @Override
    public String mset(String... keysvalues) {
        Jedis jedis = jedisPool.getResource();
        String result = jedis.mset(keysvalues);
        jedis.close();
        return result;
    }

    @Override
    public Long msetnx(String... keysvalues) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.msetnx(keysvalues);
        jedis.close();
        return result;
    }

    @Override
    public String psetex(String key, long milliseconds, String value) {
        Jedis jedis = jedisPool.getResource();
        String result = jedis.psetex(key, milliseconds, value);
        jedis.close();
        return result;
    }

    @Override
    public Long incr(String key) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.incr(key);
        jedis.close();
        return result;
    }

    @Override
    public Long incrBy(String key, long integer) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.incrBy(key, integer);
        jedis.close();
        return result;
    }

    @Override
    public Double incrByFloat(String key, double value) {
        Jedis jedis = jedisPool.getResource();
        Double result = jedis.incrByFloat(key, value);
        jedis.close();
        return result;
    }

    @Override
    public Long decr(String key) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.decr(key);
        jedis.close();
        return result;
    }

    @Override
    public Long decrBy(String key, long integer) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.decrBy(key, integer);
        jedis.close();
        return result;
    }

    @Override
    public Long append(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.append(key, value);
        jedis.close();
        return result;
    }

}
