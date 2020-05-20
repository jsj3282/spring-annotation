package com.care.dao;

import org.springframework.stereotype.Repository;

@Repository
public class TestDAO {
	
	//Repository에서 객체생성, 주소 요쳥할때 객체 한번 더 생성, 두번 생성
	public TestDAO() {
		System.out.println("dao 생성자 실행!!!");
	}
	public void test() {
		System.out.println("dao test 입니다.");
	}
	public void test02() {
		System.out.println("dao test02(B) 입니다.");
		
	}
}
