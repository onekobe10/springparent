package com.gankki.redis.service.impl;

import com.gankki.redis.service.IRedisHashService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ScanResult;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Redis Hash datatype ServiceImpl
 * @author liuhao
 * @date 2020/01/06
 */
@Slf4j
@Service
public class IRedisHashServiceImpl implements IRedisHashService {
    @Autowired
    private JedisPool jedisPool;

    @Override
    public Long hset(String key, String field, String value) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.hset(key, field, value);
        jedis.close();
        return result;
    }

    @Override
    public Long hdel(String key, String... fields) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.hdel(key, fields);
        jedis.close();
        return result;
    }

    @Override
    public Boolean hexists(String key, String field) {
        Jedis jedis = jedisPool.getResource();
        Boolean result = jedis.hexists(key, field);
        jedis.close();
        return result;
    }

    @Override
    public String hget(String key, String field) {
        Jedis jedis = jedisPool.getResource();
        String result = jedis.hget(key, field);
        jedis.close();
        return result;
    }

    @Override
    public Map<String, String> hgetAll(String key) {
        Jedis jedis = jedisPool.getResource();
        Map<String, String> result = jedis.hgetAll(key);
        jedis.close();
        return result;
    }

    @Override
    public Long hincrBy(String key, String field, long value) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.hincrBy(key, field, value);
        jedis.close();
        return result;
    }

    @Override
    public Double hincrByFloat(String key, String field, double value) {
        Jedis jedis = jedisPool.getResource();
        Double result = jedis.hincrByFloat(key, field, value);
        jedis.close();
        return result;
    }

    @Override
    public Set<String> hkeys(String key) {
        Jedis jedis = jedisPool.getResource();
        Set<String> result = jedis.hkeys(key);
        jedis.close();
        return result;
    }

    @Override
    public Long hlen(String key) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.hlen(key);
        jedis.close();
        return result;
    }

    @Override
    public List<String> hmget(String key, String... fields) {
        Jedis jedis = jedisPool.getResource();
        List<String> result = jedis.hmget(key, fields);
        jedis.close();
        return result;
    }

    @Override
    public String hmset(String key, Map<String, String> hash) {
        Jedis jedis = jedisPool.getResource();
        String result = jedis.hmset(key, hash);
        jedis.close();
        return result;
    }

    @Override
    public Long hsetnx(String key, String field, String value) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.hsetnx(key, field, value);
        jedis.close();
        return result;
    }

    @Override
    public List<String> hvals(String key) {
        Jedis jedis = jedisPool.getResource();
        List<String> result = jedis.hvals(key);
        jedis.close();
        return result;
    }

    @Override
    public ScanResult<Map.Entry<String, String>> hscan(String key, String cursor) {
        Jedis jedis = jedisPool.getResource();
        ScanResult<Map.Entry<String, String>> result = jedis.hscan(key, cursor);
        jedis.close();
        return result;
    }
}
