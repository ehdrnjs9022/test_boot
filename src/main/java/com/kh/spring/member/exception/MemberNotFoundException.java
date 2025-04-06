package com.kh.spring.member.exception;

public class MemberNotFoundException extends RuntimeException {
	
	public MemberNotFoundException (String message) {
		super(message);
	}
	
}
