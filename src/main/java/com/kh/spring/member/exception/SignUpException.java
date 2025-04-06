package com.kh.spring.member.exception;

public class SignUpException extends RuntimeException{
	
	public SignUpException (String message) {
		super(message);
	}
}
