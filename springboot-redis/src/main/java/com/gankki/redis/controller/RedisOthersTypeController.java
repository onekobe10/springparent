package com.gankki.redis.controller;

import com.gankki.redis.service.IRedisHashService;
import com.gankki.redis.service.IRedisOthersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.ScanResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
* Redis others datatype Controller
* @author liuhao
* @date 2020/1/12
*/
@RestController
@RequestMapping("/redis/others")
public class RedisOthersTypeController {
    @Autowired
    private IRedisOthersService redisOthersService;

}

