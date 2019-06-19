package com.gankki.redis.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * redis客户端接口
 *
 * @author lv
 *
 */
public interface IRedisService {

    public String set(final String key, String value);

    public String set(final byte[] key, final byte[] value);

    public String get(final String key);

    public byte[] get(final byte[] key);

    public Long del(String key);

    public Long del(final byte[] key);

    public Long del(final String... keys);

    public Long del(final byte[]... keys);

    public Boolean exists(final String key);

    public Long expire(final String key, final int seconds);

    public Long expire(final byte[] key, final int seconds);

    public Long ttl(final String key);

    public Long incr(final String key);

    public Long hset(final String key, final String field, final String value);

    public String hget(final String key, final String field);

    public Map<String, String> hgetAll(final String key);

    public Long hdel(final String key, final String... field);

    public Long hIncrBy(final String key, final String field, long value);

    public Set<String> zrangeByScore(String key, Long min, Long max);

    public List<String> srandMember(String key, int count);

    public Long zadd(final String key, Map<String, Double> scoreMembers);

    public Long sadd(final String key, String member);

    public Long srem(final String key, String member);

}
