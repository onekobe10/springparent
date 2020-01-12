package com.gankki.redis.service;

import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;

import java.util.Set;

/**
 * Redis Set datatype Service
 *
 * @author liuhao
 * @date 2020/1/12
 */
public interface IRedisSetService {

    Long sadd(String key, String... members);

    Long scard(String key);

    Set<String> sdiff(String... keys);

    Long sdiffstore(String dstkey, String... keys);

    Set<String> sinter(String... keys);

    Long sinterstore(String dstkey, String... keys);

    Boolean sismember(String key, String member);

    Set<String> smembers(String key);

    Long smove(String srckey, String dstkey, String member);

    String spop(String key);

    String srandmember(String key);

    Long srem(String key, String... members);

    Set<String> sunion(String... keys);

    Long sunionstore(String dstkey, String... keys);

    ScanResult<String> sscan(String key, String cursor, ScanParams params);

}
