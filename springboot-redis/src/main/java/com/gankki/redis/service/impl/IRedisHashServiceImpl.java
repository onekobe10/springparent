package com.gankki.redis.service.impl;

import com.gankki.redis.service.IRedisHashService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;

/**
 * Redis Hash datatype ServiceImpl
 * @author liuhao
 * @date 2020/01/06
 */
@Slf4j
@Service
public class IRedisHashServiceImpl implements IRedisHashService {
    @Autowired
    private JedisPool jedisPool;

    @Override
    public Long hdel(String key, String... fields) {
        return null;
    }
}
