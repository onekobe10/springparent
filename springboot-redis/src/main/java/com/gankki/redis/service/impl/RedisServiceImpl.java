package com.gankki.redis.service.impl;

import com.gankki.redis.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Jedis单机版
 *
 * @author lv
 *
 */
@Service
public class RedisServiceImpl implements IRedisService {

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
    public String set(byte[] key, byte[] value) {
        Jedis jedis = jedisPool.getResource();
        String result = jedis.set(key, value);
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
    public byte[] get(byte[] key) {
        Jedis jedis = jedisPool.getResource();
        byte[] result = jedis.get(key);
        jedis.close();

        return result;
    }

    @Override
    public Long del(String key) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.del(key);
        jedis.close();

        return result;
    }

    @Override
    public Long del(byte[] key) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.del(key);
        jedis.close();

        return result;
    }

    @Override
    public Long del(String... keys) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.del(keys);
        jedis.close();

        return result;
    }

    @Override
    public Long del(byte[]... keys) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.del(keys);
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
    public Long expire(byte[] key, int seconds) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.expire(key, seconds);
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
    public Long incr(String key) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.incr(key);
        jedis.close();

        return result;
    }

    @Override
    public Long hset(String key, String field, String value) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.hset(key, field, value);
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
    public Long hdel(String key, String... fields) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.hdel(key, fields);
        jedis.close();

        return result;
    }

    @Override
    public Long hIncrBy(String key, String field, long value) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.hincrBy(key, field,value);
        jedis.close();
        return result;
    }

    @Override
    public Set<String> zrangeByScore(String key,Long min,Long max){
        Jedis jedis = jedisPool.getResource();
        Set<String> results = jedis.zrangeByScore(key, min, max);
        jedis.close();
        return results;
    }

    @Override
    public List<String> srandMember(String key, int count) {
        Jedis jedis = jedisPool.getResource();
        List<String> result = jedis.srandmember(key, count);
        jedis.close();
        return result;
    }

	/**  
	 * @Title: zadd  
	 * @Description: TODO
	 * @param TODO
	 * @return TODO
	 */ 
	@Override
	public Long zadd(String key, Map<String, Double> scoreMembers) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.zadd(key, scoreMembers);
		jedis.close();
		return result;
	}

	/**  
	 * @Title: sadd  
	 * @Description: TODO
	 * @param TODO
	 * @return TODO
	 */ 
	@Override
	public Long sadd(String key, String member) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.sadd(key, member);
		jedis.close();
		return result;
	}

	/**  
	 * @Title: srem  
	 * @Description: TODO
	 * @param TODO
	 * @return TODO
	 */ 
	@Override
	public Long srem(String key, String member) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.srem(key, member);
		jedis.close();
		return result;
	}
}
