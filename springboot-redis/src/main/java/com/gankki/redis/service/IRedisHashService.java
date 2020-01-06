package com.gankki.redis.service;

/**
 * Redis Hash datatype Service
 * @author liuhao
 * @date 2020/01/06
 */
public interface IRedisHashService {

    Long hdel(String key, String... fields);

}
