package com.gankki.product.service;

import java.util.Map;

import com.gankki.product.pojo.UserPo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient("user")
@Service
public interface UserService {

	@GetMapping("/user/{id}")
	UserPo getUser(@PathVariable("id") Long id);

	@PostMapping("/insert")
	Map<String, Object> addUser(@RequestBody UserPo user);

	@PostMapping("/update/{userName}")
	Map<String, Object> updateName(
			@PathVariable("userName") String userName,
			@RequestBody Long id);

	@GetMapping("/timeout")
	String testTimeout();
}