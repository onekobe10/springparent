package com.gankki.data.gankki.controller;

import com.gankki.data.gankki.entity.MySQLBean;
import com.gankki.data.gankki.service.MySQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/4/23
 */
@RestController
@RequestMapping("/mysql")
public class MySQL30wController {

	@Autowired
	private MySQLService mySQLService;

	@GetMapping("/genData")
	public String gengerateMySQLData() throws Exception{
		StringBuilder sb = null;
		for (int i = 1; i <= 200000; i++) {
			sb = new StringBuilder();
			MySQLBean mySQLBean = new MySQLBean();
			String uuid = UUID.randomUUID().toString();
			for(int j=0;j<5;j++){
				sb.append(getChinese((int) (Math.random() * 100)));
			}
			mySQLBean.setCnWord1(sb.toString());
			mySQLBean.setCnWord2(sb.toString());
			mySQLBean.setUuid1(uuid);
			mySQLBean.setUuid2(uuid);
			mySQLBean.setIntTest((int) (Math.random() * 100));
			this.mySQLService.save(mySQLBean);
		}
	return "测试";
	}


	public static void main(String[] args) throws Exception{
		String ss="";
		for(int i=0;i<5;i++){
			ss+= MySQL30wController.getChinese(i);
		}
		System.out.println(ss);

		StringBuilder sb = new StringBuilder("111*** ");
		List<String> list = new ArrayList<>(5);
		for (int i = 0; i < 5; i++) {
			sb.append(i);
			list.add(sb.toString());
		}

		System.out.println(list.toString());
	}

	public static String getChinese(long seed)
			throws UnsupportedEncodingException
	{
		String str=null;
		int highpos,lowpos;
		Random random=new Random(seed);
		highpos=(176+Math.abs(random.nextInt(39)));
		lowpos=(161+Math.abs(random.nextInt(93)));
		byte[] bb=new byte[2];
		bb[0]=new Integer(highpos).byteValue();
		bb[1]=new Integer(lowpos).byteValue();
		str=new String(bb,"GBK");
		return str;
	}
}
