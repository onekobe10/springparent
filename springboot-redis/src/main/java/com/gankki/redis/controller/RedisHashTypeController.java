package com.gankki.redis.controller;

import com.gankki.redis.service.IRedisHashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* Redis Hash datatype Controller
* @author liuhao
* @date 2020/01/06
*/
@RestController
@RequestMapping("/redis/hash")
public class RedisHashTypeController {
    @Autowired
    private IRedisHashService redisHashService;
    

}

