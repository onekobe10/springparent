package com.gankki.data.jpa.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gankki.data.jpa.entity.Role;
import com.gankki.data.jpa.entity.SysUser;
import com.gankki.data.jpa.entity.User;
import com.gankki.data.jpa.service.jpa.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liuhao
 * @desc 测试类
 * @createDate 2019/1/21
 */
@Controller
@RequestMapping(value = "jpaOperation")
@Api(value = "jpaOperation", tags = "jpa相关操作")
public class JpaTestController {
	@Autowired
	private SysUserService sysUserService;

	@ApiOperation(value = "jpa测试一对一")
	@GetMapping(value = "jpaOperationOneToOne")
	public void jpaOperation(Integer id) {
		SysUser sysUser = this.sysUserService.findUserById(id);
		System.out.println(sysUser.getUsername());
        /*Set<SysRole> sysRoleSet = sysUser.getSysRoleSet();
        if (sysRoleSet != null) {
            for (SysRole sysRole : sysRoleSet) {
                System.out.println(sysRole.getRolename());
            }
        }*/
	}

	@ApiOperation(value = "jpa测试死循环1")
	@GetMapping(value = "jpaOperationCircle1")
	public void jpaOperationCircle1(Integer id) {
		Set<Role> roles = new HashSet<Role>();
		Role role1 = new Role();
		role1.setRoleName("USER");
		Role role2 = new Role();
		role2.setRoleName("ADMIN");
		roles.add(role1);
		roles.add(role2);

		User user = new User();
		user.setRoles(roles);
		user.setUsername("张三");
		this.sysUserService.save(user);
	}

	@ApiOperation(value = "jpa测试死循环2")
	@GetMapping(value = "jpaOperationCircle2")
	@ResponseBody
	public Object jpaOperationCircle2() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.writeValueAsString(sysUserService.findAll());
		return null;
		//System.out.println(JSON.toJSONString(users));
        /*for (User user : users) {
            System.out.println(user);
        }*/
	}
}
