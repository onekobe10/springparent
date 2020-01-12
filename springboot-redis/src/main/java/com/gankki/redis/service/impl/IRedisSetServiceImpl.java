package com.gankki.redis.service.impl;

import com.gankki.redis.service.IRedisSetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;

import java.util.Set;

/**
 * Redis Set datatype ServiceImpl
 * @author liuhao
 * @date 2020/1/12
 */
@Slf4j
@Service
public class IRedisSetServiceImpl implements IRedisSetService {
    @Autowired
    private JedisPool jedisPool;

    @Override
    public Long sadd(String key, String... members) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.sadd(key, members);
        jedis.close();
        return result;
    }

    @Override
    public Long scard(String key) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.sadd(key);
        jedis.close();
        return result;
    }

    @Override
    public Set<String> sdiff(String... keys) {
        Jedis jedis = jedisPool.getResource();
        Set<String> result = jedis.sdiff(keys);
        jedis.close();
        return result;
    }

    @Override
    public Long sdiffstore(String dstkey, String... keys) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.sdiffstore(dstkey, keys);
        jedis.close();
        return result;
    }

    @Override
    public Set<String> sinter(String... keys) {
        Jedis jedis = jedisPool.getResource();
        Set<String> result = jedis.sinter(keys);
        jedis.close();
        return result;
    }

    @Override
    public Long sinterstore(String dstkey, String... keys) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.sinterstore(dstkey, keys);
        jedis.close();
        return result;
    }

    @Override
    public Boolean sismember(String key, String member) {
        Jedis jedis = jedisPool.getResource();
        Boolean result = jedis.sismember(key, member);
        jedis.close();
        return result;
    }

    @Override
    public Set<String> smembers(String key) {
        Jedis jedis = jedisPool.getResource();
        Set<String> result = jedis.smembers(key);
        jedis.close();
        return result;
    }

    @Override
    public Long smove(String srckey, String dstkey, String member) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.smove(dstkey, dstkey, member);
        jedis.close();
        return result;
    }

    @Override
    public String spop(String key) {
        Jedis jedis = jedisPool.getResource();
        String result = jedis.spop(key);
        jedis.close();
        return result;
    }

    @Override
    public String srandmember(String key) {
        Jedis jedis = jedisPool.getResource();
        String result = jedis.srandmember(key);
        jedis.close();
        return result;
    }

    @Override
    public Long srem(String key, String... members) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.srem(key, members);
        jedis.close();
        return result;
    }

    @Override
    public Set<String> sunion(String... keys) {
        Jedis jedis = jedisPool.getResource();
        Set<String> result = jedis.sunion(keys);
        jedis.close();
        return result;
    }

    @Override
    public Long sunionstore(String dstkey, String... keys) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.sunionstore(dstkey, keys);
        jedis.close();
        return result;
    }

    @Override
    public ScanResult<String> sscan(String key, String cursor, ScanParams params) {
        Jedis jedis = jedisPool.getResource();
        ScanResult<String> result = jedis.sscan(key, cursor, params);
        jedis.close();
        return result;
    }
}
