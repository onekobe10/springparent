package com.gankki.redis.controller;

import com.gankki.redis.service.IRedisSetService;
import com.gankki.redis.service.IRedisSortedSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* Redis SortedSet datatype Controller
* @author liuhao
* @date 2020/1/12
*/
@RestController
@RequestMapping("/redis/sortedset")
public class RedisSortedSetTypeController {
    @Autowired
    private IRedisSortedSetService redisSortedSetService;

}

