package com.gankki.data.jpa.controller;

import com.gankki.data.jpa.service.impl.jpa.PurchaseServiceI4Jpampl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


/**** imports ****/
// REST风格控制器
@RestController
@RequestMapping("/jpa")
public class Purchase4JpaController {
	@Autowired
	PurchaseServiceI4Jpampl purchaseService = null;

	// 定义JSP视图
	@GetMapping("/test")
	public ModelAndView testPage() {
		ModelAndView mv = new ModelAndView("test4jpa");
		return mv;
	}

	@PostMapping("/purchase")
	public Result purchase(Long userId, Long productId, Integer quantity) {
		boolean success = purchaseService.purchase(userId, productId, quantity);
		String message = success ? "抢购成功" : "抢购失败";
		Result result = new Result(success, message);
		return result;
	}

	// 响应结果
	class Result {
		private boolean success = false;
		private String message = null;

		public Result() {
		}

		public Result(boolean success, String message) {
			this.success = success;
			this.message = message;
		}

		/**** setter and getter ****/

		public boolean isSuccess() {
			return success;
		}

		public void setSuccess(boolean success) {
			this.success = success;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

	}
}