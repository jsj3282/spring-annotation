package com.care.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.care.service.ServiceA;
import com.care.service.ServiceB;
import com.care.service.TestService;

@Controller
public class TestController {
	
	ApplicationContext ac = ApplicationContextprovider.ac;		//bean객체 가져올 수 있음
	
	//@Autowired
	private TestService ser;
	
	//@Autowired
	private ServiceA a;
	//@Autowired
	private ServiceB b;
	
	@RequestMapping("test")
	public void test() {
		//ser = new ServiceA();
		//ser.execute();
		//a.execute();
		ser = ac.getBean("serviceA", ServiceA.class);	//getBean할때 클래스 첫글자는 원래 대문자여도 무조건 소문자처리
		ser.execute();
	}
	
	@RequestMapping("test02")
	public void test02() {
		//ser.execute();		
		//에러발생, TestService Autowired는 부모가 했는데 그 자식이 2개라서 충돌
		//방법1 : 자식별로 따로따로 Autowired 해줌
		//방법2 : ApplicationContextAware를 구현한 클래스파일 만들기
		//b.execute();
		ser = ac.getBean("serviceB", ServiceB.class);
		ser.execute();
	}
}
