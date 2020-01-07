package com.gankki.redis.service;

import redis.clients.jedis.ScanResult;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Redis Hash datatype Service
 * @author liuhao
 * @date 2020/01/06
 */
public interface IRedisHashService {

    Long hset(String key, String field, String value);

    Long hdel(String key, String... fields);

    Boolean hexists(String key, String field);

    String hget(String key, String field);

    Map<String, String> hgetAll(String key);

    Long hincrBy(String key, String field, long value);

    Double hincrByFloat(String key, String field, double value);

    Set<String> hkeys(String key);

    Long hlen(String key);

    List<String> hmget(String key, String... fields);

    String hmset(String key, Map<String, String> hash);

    Long hsetnx(String key, String field, String value);

    List<String> hvals(String key);

    ScanResult<Map.Entry<String, String>> hscan(String key, String cursor);

}
