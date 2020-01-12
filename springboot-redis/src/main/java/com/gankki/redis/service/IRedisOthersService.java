package com.gankki.redis.service;

import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;

import java.util.Set;

/**
 * Redis others datatype Service
 *
 * @author liuhao
 * @date 2020/1/12
 */
public interface IRedisOthersService {

    Long del(String key);

    byte[] dump(final String key);

    Boolean exists(final String key);

    Long expire(final String key, final int seconds);

    Long expireAt(final String key, final long unixTime);

    Long pexpire(final String key, final long milliseconds);

    Long pexpireAt(final String key, final long millisecondsTimestamp);

    Set<String> keys(final String pattern);

    Long move(final String key, final int dbIndex);

    Long persist(final String key);

    Long pttl(final String key);

    Long ttl(final String key);

    String randomKey();

    String rename(final String oldkey, final String newkey);

    Long renamenx(final String oldkey, final String newkey);

    String type(final String key);
}
