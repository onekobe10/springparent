package com.gankki.redis.controller;

import com.gankki.redis.service.IRedisStringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Redis String datatype Controller
 * @author liuhao
 * @date 2019/12/1
 */
@RestController
@RequestMapping("redis/string")
public class RedisStringTypeController {
	@Autowired
	private IRedisStringService redisStringService;

	@RequestMapping("test")
	public void test(){
		// 设置指定 key 的值
		// 在 Redis 2.6.12 以前版本， SET 命令总是返回 OK 。
		// 从 Redis 2.6.12 版本开始， SET 在设置操作成功完成时，才返回 OK 。
		String setResult = redisStringService.set("liu", "hao,hello world");
		System.out.println("setResult：" + setResult);

		// 设置指定 key 的值和失效时间，单位是秒
		String setWithExpireResult = redisStringService.set("expire", "expire", 10000);
		System.out.println("setWithExpireResult：" + setWithExpireResult);

		// 获取指定 key 的值。
		String getResult = redisStringService.get("liu");
		System.out.println("getResult：" + getResult);

		// 返回 key 中字符串值的子字符
		// 字符串的截取范围由 start 和 end 两个偏移量决定(包括 start 和 end 在内)。
		// 截取得到的子字符串。
		redisStringService.set("getRange", "getRange");
		String getRangeResult = redisStringService.getRange("getRange", 0, 1);
		System.out.println("getRangeResult：" + getRangeResult);

		// 将给定 key 的值设为 value ，并返回 key 的旧值(old value)
		redisStringService.set("getSet", "getSetOld");
		String getSetResult = redisStringService.getSet("getSet", "getSetNew");
		System.out.println("getSetResult：" + getSetResult);

		// 对 key 所储存的字符串值，设置或清除指定偏移量上的位(bit)。
		// 从左到右偏移计算
		// 指定偏移量原来储存的位。
		redisStringService.set("setbit", "setbit");
		Boolean setbitResult = redisStringService.setbit("setbit", 1, "0");
		// true
		System.out.println("setbitResult：" + setbitResult);

		// 对 key 所储存的字符串值，获取指定偏移量上的位(bit)。
		Boolean getbitResult = redisStringService.getbit("setbit", 1);
		// false
		System.out.println("getbitResult：" + getbitResult);

		// 获取所有(一个或多个)给定 key 的值。
		List<String> mgetResult = redisStringService.mget("liu", "setbit");
		System.out.println("mgetResult：" + mgetResult);

		// 将值 value 关联到 key ，并将 key 的过期时间设为 seconds (以秒为单位)。
		// 设置成功时返回 OK 。
		redisStringService.set("setex", "setex");
		String setexResult = redisStringService.setex("setex", 60, "setbit");
		System.out.println("setexResult：" + setexResult);

		// **只有在 key 不存在时设置 key 的值。设置成功，返回 1 。 设置失败，返回 0 。**
		Long setnxResult = redisStringService.setnx("setnx1", "setnx1");
		System.out.println("setnxResult：" + setnxResult);

		// 用 value 参数覆写给定 key 所储存的字符串值，从偏移量 offset 开始。
		// 被修改后的字符串长度。
		redisStringService.set("setrange", "setrange");
		Long setrangeResult = redisStringService.setrange("setrange", 1, "haha");
		System.out.println("setrangeResult：" + setrangeResult + "...." + redisStringService.get("setrange"));

		// 返回 key 所储存的字符串值的长度。
		redisStringService.set("strLen", "strLen");
		Long strLenResult = redisStringService.strlen("strLen");
		System.out.println("strLenResult：" + strLenResult);

		// 同时设置一个或多个 key-value 对。总是返回 OK 。
		String msetResult = redisStringService.mset("key1", "value1", "key2", "value2");
		System.out.println("msetResult：" + msetResult);

		// 同时设置一个或多个 key-value 对，当且仅当所有给定 key 都不存在。
		// 当所有 key 都成功设置，返回 1 。 如果所有给定 key 都设置失败(至少有一个 key 已经存在)，那么返回 0 。
		Long msetnxResult = redisStringService.msetnx("msetnx1","msetnxvalue1","msetnx2","msetnxvalue2");
		System.out.println("msetnxResult：" + msetnxResult);

		// 这个命令和 SETEX 命令相似，但它以毫秒为单位设置 key 的生存时间，而不是像 SETEX 命令那样，以秒为单位。
		// 设置成功时返回 OK 。
		String psetexResult = redisStringService.psetex("psetex", 10000, "psetvalue");
		System.out.println("psetexResult：" + psetexResult);

		/**
		 * 牵涉到运算的字符串必须为数字字符串：
		 * redis.clients.jedis.exceptions.JedisDataException: ERR value is not an integer or out of range
		 */
		// 将 key 中储存的数字值增一。
		redisStringService.set("incr", "1");
		Long incrResult = redisStringService.incr("incr");
		System.out.println("incrResult：" + incrResult);

		// 将 key 所储存的值加上给定的增量值（increment） 。
		redisStringService.set("incrBy", "1");
		Long incrByResult = redisStringService.incrBy("incrBy", 20);
		System.out.println("incrByResult：" + incrByResult);

		// 将 key 所储存的值加上给定的浮点增量值（increment） 。
		redisStringService.set("incrByFloat", "1.00");
		Double incrByFloatResult = redisStringService.incrByFloat("incrByFloat", 1.01);
		System.out.println("incrByFloatResult：" + incrByFloatResult);
		
		// 将 key 中储存的数字值减一。
		redisStringService.set("decr", "2");
		Long decrResult = redisStringService.decr("decr");
		System.out.println("decrResult：" + decrResult);

		// key 所储存的值减去给定的减量值（decrement） 。
		// 减去指定减量值之后， key 的值。
		redisStringService.set("decrBy", "0");
		Long decrByResult = redisStringService.decrBy("decrBy", 2);
		System.out.println("decrByResult：" + decrByResult);

		// 如果 key 已经存在并且是一个字符串， APPEND 命令将指定的 value 追加到该 key 原来值（value）的末尾。
		// 追加指定值之后， key 中字符串的长度。
		redisStringService.set("append", "2");
		Long appendResult = redisStringService.append("append", "......2");
		System.out.println("appendResult：" + appendResult + "     " + redisStringService.get("append"));

	}
}
