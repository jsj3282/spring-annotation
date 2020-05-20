package com.care.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.care.dao.TestDAO;

@Service
public class ServiceA implements TestService{
	
	@Autowired
	@Qualifier("dao02")
	private TestDAO dao;
	//servlet-context.xml, repository로 인해 객체가 두개생성
	//둘중에 어떤 객체 쓸지 명시해 주는게 qualifier
	
	@Override
	public void execute() {
		//dao = new TestDAO();
		System.out.println("dao : " + dao); //dao는 null, 
		dao.test();	
		// No unique bean of type [com.care.dao.TestDAO] is defined: expected single matching bean but found 2: [dao02, testDAO]
		//nullpointerException : TestController가 serviceA를 쓰려고 하니 serviceA는 @Service annotation이 붙지 않아서 Autowired로 의존성 주입이 안됨
		//Autowired annotation은  @Service, @Repository, @Controller, @Conponent - 해당 값이 전부 bean으로 만들어져야한다
		//따라서 @Service를 붙이기 전에는 @Autowired를 사용할 수 없다.
	}

}
