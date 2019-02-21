package com.controller;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HolleWordController {

	/**
	 * 1. 使用RequestMapping注解来映射请求的URL 2. 返回值会通过视图解析器解析为实际的物理视图,
	 * 对于InternalResourceViewResolver视图解析器，会做如下解析 通过prefix+returnVal+suffix
	 * 这样的方式得到实际的物理视图，然后会转发操作 "/WEB-INF/views/success.jsp"
	 * 
	 * @return
	 */
	@RequestMapping("/helloworld")
	public String hello() {
		System.out.println("hello world");
		return "success";
	}
	
	//直接返回数据，不经过视图解析器
	@RequestMapping(value="/json", produces={"text/json; charset=UTF-8"})
	//@RequestMapping("/json")
	@ResponseBody  //返回值直接写入响应体
	public String getJson() {
		
		String str = "这里是直接返回的数据";
		return str;
	}
	
	//带参的方法
	@RequestMapping(value="/data/{id},{name}",produces={"text/json; charset=UTF-8"})
	@ResponseBody  //返回值直接写入响应体
	public String getData(@PathVariable ("id") String id ,@PathVariable ("name") String name ) {
	
		String str = "id:"+id+",name="+name;
		return str;
	}
	
	
	
	
	
	
	
	
	
	
	
}
