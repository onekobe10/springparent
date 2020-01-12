package com.gankki.redis.service.impl;

import com.gankki.redis.service.IRedisSortedSetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.*;

import java.util.Set;

/**
 * Redis SortedSet datatype Service
 * @author liuhao
 * @date 2020/1/12
 */
@Slf4j
@Service
public class IRedisSortedSetServiceImpl implements IRedisSortedSetService {
    @Autowired
    private JedisPool jedisPool;

    @Override
    public Long zadd(String key, double score, String member) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.zadd(key, score, member);
        jedis.close();
        return result;
    }

    @Override
    public Long zcard(String key) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.zcard(key);
        jedis.close();
        return result;
    }

    @Override
    public Long zcount(String key, double min, double max) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.zcount(key, min, max);
        jedis.close();
        return result;
    }

    @Override
    public Double zincrby(String key, double score, String member) {
        Jedis jedis = jedisPool.getResource();
        Double result = jedis.zincrby(key, score, member);
        jedis.close();
        return result;
    }

    @Override
    public Long zinterstore(String dstkey, String... sets) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.zinterstore(dstkey, sets);
        jedis.close();
        return result;
    }

    @Override
    public Long zlexcount(String key, String min, String max) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.zlexcount(key, min, max);
        jedis.close();
        return result;
    }

    @Override
    public Set<String> zrange(String key, long start, long end) {
        Jedis jedis = jedisPool.getResource();
        Set<String> result = jedis.zrange(key, start, end);
        jedis.close();
        return result;
    }

    @Override
    public Set<String> zrangeByLex(String key, String min, String max) {
        Jedis jedis = jedisPool.getResource();
        Set<String> result = jedis.zrangeByLex(key, min, max);
        jedis.close();
        return result;
    }

    @Override
    public Set<String> zrangeByScore(String key, double min, double max) {
        Jedis jedis = jedisPool.getResource();
        Set<String> result = jedis.zrangeByScore(key, min, max);
        jedis.close();
        return result;
    }

    @Override
    public Long zrank(String key, String member) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.zrank(key, member);
        jedis.close();
        return result;
    }

    @Override
    public Long zrem(String key, String... members) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.zrem(key, members);
        jedis.close();
        return result;
    }

    @Override
    public Long zremrangeByRank(String key, long start, long end) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.zremrangeByRank(key, start, end);
        jedis.close();
        return result;
    }

    @Override
    public Long zremrangeByScore(String key, double start, double end) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.zremrangeByScore(key, start, end);
        jedis.close();
        return result;
    }

    @Override
    public Set<String> zrevrange(String key, long start, long end) {
        Jedis jedis = jedisPool.getResource();
        Set<String> result = jedis.zrevrange(key, start, end);
        jedis.close();
        return result;
    }

    @Override
    public Set<String> zrevrangeByScore(String key, double max, double min) {
        Jedis jedis = jedisPool.getResource();
        Set<String> result = jedis.zrevrangeByScore(key, max, min);
        jedis.close();
        return result;
    }

    @Override
    public Long zrevrank(String key, String member) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.zrevrank(key, member);
        jedis.close();
        return result;
    }

    @Override
    public Double zscore(String key, String member) {
        Jedis jedis = jedisPool.getResource();
        Double result = jedis.zscore(key, member);
        jedis.close();
        return result;
    }

    @Override
    public Long zunionstore(String dstkey, String... sets) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.zunionstore(dstkey, sets);
        jedis.close();
        return result;
    }

    @Override
    public ScanResult<Tuple> zscan(String key, String cursor, ScanParams params) {
        Jedis jedis = jedisPool.getResource();
        ScanResult<Tuple> result = jedis.zscan(key, cursor, params);
        jedis.close();
        return result;
    }
}
