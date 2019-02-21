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
	 * 1. ʹ��RequestMappingע����ӳ�������URL 2. ����ֵ��ͨ����ͼ����������Ϊʵ�ʵ�������ͼ,
	 * ����InternalResourceViewResolver��ͼ���������������½��� ͨ��prefix+returnVal+suffix
	 * �����ķ�ʽ�õ�ʵ�ʵ�������ͼ��Ȼ���ת������ "/WEB-INF/views/success.jsp"
	 * 
	 * @return
	 */
	@RequestMapping("/helloworld")
	public String hello() {
		System.out.println("hello world");
		return "success";
	}
	
	//ֱ�ӷ������ݣ���������ͼ������
	@RequestMapping(value="/json", produces={"text/json; charset=UTF-8"})
	//@RequestMapping("/json")
	@ResponseBody  //����ֱֵ��д����Ӧ��
	public String getJson() {
		
		String str = "������ֱ�ӷ��ص�����";
		return str;
	}
	
	//���εķ���
	@RequestMapping(value="/data/{id},{name}",produces={"text/json; charset=UTF-8"})
	@ResponseBody  //����ֱֵ��д����Ӧ��
	public String getData(@PathVariable ("id") String id ,@PathVariable ("name") String name ) {
	
		String str = "id:"+id+",name="+name;
		return str;
	}
	
	
	
	
	
	
	
	
	
	
	
}
