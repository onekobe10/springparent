package com.gankki.redis.service;

import java.util.List;

/**
 * Redis String datatype
 * @author liuhao
 * @date 2019/12/1
 */
public interface IRedisStringService {

    String set(String key, String value);

    String set(String key, String value, int liveTime);

    String get(String key);

    String getRange(String key, long startOffset, long endOffset);

    String getSet(String key, String value);

    Boolean setbit(String key, long offset, String value);

    Boolean getbit(String key, long offset);

    List<String> mget(String... keys);

    String setex(String key, int seconds, String value);

    Long setnx(String key, String value);

    Long setrange(String key, long offset, String value);

    Long strlen(String key);

    String mset(String... keysvalues);

    Long msetnx(String... keysvalues);

    String psetex(String key, long milliseconds, String value);

    Long incr(String key);

    Long incrBy(String key, long integer);

    Double incrByFloat(String key, double value);

    Long decr(String key);

    Long decrBy(String key, long integer);

    Long append(String key, String value);

}
