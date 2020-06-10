package com.iu.s1.member;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

public class MemberVO {

	//비어있으면 X
	@NotEmpty
	private String id;
	
	//비어있으면 X
	//4글자 이상 10글자 이하
	@NotEmpty
	@Size(max = 10, min = 4)
	private String pw;
	
	private String pwCheck;
	
	//0살 이상 200살 이하
	@Range(max = 200, min = 0)
	private int age;
	//email 형식 아이디@naver.com
	@Email
	private String email;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwCheck() {
		return pwCheck;
	}
	public void setPwCheck(String pwCheck) {
		this.pwCheck = pwCheck;
	}
	
	
}
