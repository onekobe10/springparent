package com.gankki.redis.service;

import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;
import redis.clients.jedis.Tuple;

import java.util.Set;

/**
 * Redis SortedSet datatype Service
 *
 * @author liuhao
 * @date 2020/1/12
 */
public interface IRedisSortedSetService {

    Long zadd(String key, double score, String member);

    Long zcard(String key);

    Long zcount(String key, double min, double max);

    Double zincrby(String key, double score, String member);

    Long zinterstore(String dstkey, String... sets);

    Long zlexcount(String key, String min, String max);

    Set<String> zrange(String key, long start, long end);

    Set<String> zrangeByLex(String key, String min, String max);

    Set<String> zrangeByScore(String key, double min, double max);

    Long zrank(String key, String member);

    Long zrem(String key, String... members);

    Long zremrangeByRank(String key, long start, long end);

    Long zremrangeByScore(String key, double start, double end);

    Set<String> zrevrange(String key, long start, long end);

    Set<String> zrevrangeByScore(String key, double max, double min);

    Long zrevrank(String key, String member);

    Double zscore(String key, String member);

    Long zunionstore(String dstkey, String... sets);

    ScanResult<Tuple> zscan(String key, String cursor, ScanParams params);

}
