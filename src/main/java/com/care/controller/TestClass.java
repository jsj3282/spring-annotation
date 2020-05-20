package com.care.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.care.test.Test;

//@Service //서비스단
//@Repository //dao
//@Component //단순객체 생성할 때
public class TestClass {
	
	@Autowired
	private Test t;
	
	public TestClass() {
		System.out.println("TestClass 생성자 입니다");
	}
	public void print() {
		t.test();
		System.out.println("TestClass.print() 메소드 입니다.");
	}
}
