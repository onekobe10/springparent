package com.gankki.redis.controller;

import com.gankki.redis.service.IRedisHashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.ScanResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    @RequestMapping("test")
    public void test() {
        // 将哈希表 key 中的字段 field 的值设为 value
        // 如果字段是哈希表中的一个新建字段，并且值设置成功，返回 1 。 如果哈希表中域字段已经存在且旧值已被新值覆盖，返回 0 。
        Long hsetResult = redisHashService.hset("key", "field", "value");
        System.out.println("hsetResult：" + hsetResult);

        // 删除一个或多个哈希表字段
        // 被成功删除字段的数量，不包括被忽略的字段。
        Long hdelResult = redisHashService.hdel("key", "field", "field2");
        System.out.println("hdelResult：" + hdelResult);

        // 查看哈希表 key 中，指定的字段是否存在。
        Boolean hexistsResult = redisHashService.hexists("key", "field");
        System.out.println("hexistsResult：" + hexistsResult);

        // 获取存储在哈希表中指定字段的值。
        String hgetResult = redisHashService.hget("key", "field");
        System.out.println("hgetResult：" + hgetResult);

        // 获取在哈希表中指定 key 的所有字段和值
        Map<String, String> hgetAllResult = redisHashService.hgetAll("key");
        System.out.println("hgetAllResult：" + hgetAllResult);

        // Redis Hincrby 命令用于为哈希表中的字段值加上指定增量值。
        // 增量也可以为负数，相当于对指定字段进行减法操作。
        // 如果哈希表的 key 不存在，一个新的哈希表被创建并执行 HINCRBY 命令。
        // 如果指定的字段不存在，那么在执行命令前，字段的值被初始化为 0 。
        // 对一个储存字符串值的字段执行 HINCRBY 命令将造成一个错误。
        // 本操作的值被限制在 64 位(bit)有符号数字表示之内。
        // 执行 HINCRBY 命令之后，哈希表中字段的值。
        Long hincrByResult = redisHashService.hincrBy("key", "value", 1);
        System.out.println("hincrByResult：" + hincrByResult);

        // Redis Hincrbyfloat 命令用于为哈希表中的字段值加上指定浮点数增量值。
        // 如果指定的字段不存在，那么在执行命令前，字段的值被初始化为 0 。
        // 执行 Hincrbyfloat 命令之后，哈希表中字段的值。
        Double hincrByFloatResult = redisHashService.hincrByFloat("key", "value", 1.0d);
        System.out.println("hincrByFloatResult：" + hincrByFloatResult);

        // Redis Hkeys 命令用于获取哈希表中的所有域（field）。
        // 包含哈希表中所有域（field）列表。 当 key 不存在时，返回一个空列表。
        Set<String> hkeysResult = redisHashService.hkeys("key");
        System.out.println("hkeysResult：" + hkeysResult);

        // Redis Hlen 命令用于获取哈希表中字段的数量。
        // 哈希表中字段的数量。 当 key 不存在时，返回 0 。
        Long hlenResult = redisHashService.hlen("key");
        System.out.println("hlenResult：" + hlenResult);

        // Redis Hmget 命令用于返回哈希表中，一个或多个给定字段的值。
        // 如果指定的字段不存在于哈希表，那么返回一个 nil 值。
        // 一个包含多个给定字段关联值的表，表值的排列顺序和指定字段的请求顺序一样。
        List<String> hmgetResult = redisHashService.hmget("key", "value", "value1");
        System.out.println("hmgetResult：" + hmgetResult);

        // Redis Hmset 命令用于同时将多个 field-value (字段-值)对设置到哈希表中。
        // 此命令会覆盖哈希表中已存在的字段。
        // 如果哈希表不存在，会创建一个空哈希表，并执行 HMSET 操作。
        // 如果命令执行成功，返回 OK 。
        Map<String, String> hash = new HashMap<>();
        String hmetResult = redisHashService.hmset("key", hash);
        System.out.println("hmetResult：" + hmetResult);

        // Redis Hsetnx 命令用于为哈希表中不存在的的字段赋值 。
        // 如果哈希表不存在，一个新的哈希表被创建并进行 HSET 操作。
        // 如果字段已经存在于哈希表中，操作无效。
        // 如果 key 不存在，一个新哈希表被创建并执行 HSETNX 命令。
        // 设置成功，返回 1 。 如果给定字段已经存在且没有操作被执行，返回 0 。
        Long hsetnxResult = redisHashService.hsetnx("key", "field1", "value1");
        System.out.println("hsetnxResult：" + hsetnxResult);

        // Redis Hvals 命令返回哈希表所有域(field)的值。
        // 一个包含哈希表中所有域(field)值的列表。 当 key 不存在时，返回一个空表。
        List<String> hvalsResult = redisHashService.hvals("key");
        System.out.println("hvalsResult：" + hvalsResult);

        // 迭代哈希表中的键值对。从 cursor 开始
        ScanResult<Map.Entry<String, String>> hscanResult = redisHashService.hscan("key", "value");
        System.out.println("hscanResult：" + hscanResult);

    }

}

