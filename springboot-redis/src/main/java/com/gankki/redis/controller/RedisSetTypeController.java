package com.gankki.redis.controller;

import com.gankki.redis.service.IRedisHashService;
import com.gankki.redis.service.IRedisSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.ScanResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
* Redis Set datatype Controller
* @author liuhao
* @date 2020/1/12
*/
@RestController
@RequestMapping("/redis/set")
public class RedisSetTypeController {
    @Autowired
    private IRedisSetService redisSetService;


}

