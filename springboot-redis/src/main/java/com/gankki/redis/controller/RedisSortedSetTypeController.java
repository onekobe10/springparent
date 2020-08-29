package com.gankki.redis.controller;

import com.gankki.redis.service.IRedisSetService;
import com.gankki.redis.service.IRedisSortedSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

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

    @RequestMapping("test")
    public void test() {
        redisSortedSetService.zadd("zset", 1, "zset");

        Set<String> zset = redisSortedSetService.zrange("zset", 0, 1);
        for (String s : zset) {
            System.out.println(s);
        }

        // 如果想获取成员的分数，只能先获取成员，然后再调用 zcore 方法获取分数
        // zrangeByScore 只能返回按分数排序的成员，不能获取成员+分数
        Set<String> zsetByScore = redisSortedSetService.zrangeByScore("zset", 0, 1);
        for (String s : zsetByScore) {
            System.out.println(s);
        }

        // zset 中的分数为 Double类型
        Double zscore = redisSortedSetService.zscore("zset", "zset");
        System.out.println(zscore);

    }
}

