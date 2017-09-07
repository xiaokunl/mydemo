package cn.itcast.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.itcast.springboot.service.UserService;

/**
 * HelloController
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年9月4日 下午3:27:27
 * @version 1.0
 */
@RestController
public class HelloController {
	
	@Autowired
	private UserService userService;
	/** 配置Environment封装属性文件 */
	@Autowired
	private Environment environment; 
	/** 属性注入 */
	@Value("${name}") 
	private String name;
	/** 属性注入 */
	@Value("${url}")
	private String url;
	
	
	@GetMapping("/hello")
	public String hello(){
		System.out.println("name:" + environment.getProperty("name"));
		System.out.println("url:" + environment.getProperty("url"));
		userService.save();
		
		System.out.println("=================");
		System.out.println(name + "--->" + url);
		return "Hello Spring Boot 4!";
	}
	
}
