package com.gankki.product.controller;

import java.util.Map;

import com.gankki.product.pojo.UserPo;
import com.gankki.product.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

/**** imports ****/
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private UserService userService;

	@GetMapping("/ribbon")
	public UserPo testRibbon() {
		UserPo user = null;
		// 循环10次，然后可以看到各个用户微服务后台的日志打印
		for (int i = 0; i < 10; i++) {
			// 注意这里直接使用了USER这个服务ID，代表用户微服务系统
			// 该ID通过属性spring.application.name来指定
			user = restTemplate.getForObject("http://USER/user/" + i, UserPo.class);
			System.out.println(user.toString());
		}
		return user;
	}

	// 测试
	@PostMapping("/feign")
	public UserPo testFeign() {
		UserPo user = null;
		// 循环10次
		for (int i = 0; i < 10; i++) {
			Long id = (long) (i + 1);
			user = userService.getUser(id);
		}
		return user;
	}

	@GetMapping("/feign2")
	public Map<String, Object> testFeign2() {
		Map<String, Object> result = null;
		UserPo user = null;
		for (int i = 1; i <= 10; i++) {
			Long id = (long) i;
			user = new UserPo();
			user.setId(id);
			int level = i % 3 + 1;
			user.setUserName("user_name_" + id);
			user.setLevel(level);
			user.setNote("note_" + i);
			result = userService.addUser(user);
		}
		return result;
	}

	@GetMapping("/feign3")
	public Map<String, Object> testFeign3() {
		Map<String, Object> result = null;
		for (int i = 0; i < 10; i++) {
			Long id = (long) (i + 1);
			String userName = "user_name_" + id;
			result = userService.updateName(userName, id);
		}
		return result;
	}

	@GetMapping("/circuitBreaker1")
	@HystrixCommand(fallbackMethod = "error", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500") })
	public String circuitBreaker1() {
		return restTemplate.getForObject("http://USER/timeout", String.class);
	}

	@GetMapping("/circuitBreaker2")
	@HystrixCommand(fallbackMethod = "error")
	public String circuitBreaker2() {
		return userService.testTimeout();
	}

	/**
	 * 降级方法
	 * @return
	 */
	public String error() {
		return "超时出错,回调方法";
	}

	@PostMapping("/testPostReq")
	public Object testPostReq(@RequestBody Map map) {
		return map.get("name");
	}
}