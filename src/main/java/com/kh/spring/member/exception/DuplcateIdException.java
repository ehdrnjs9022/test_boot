package com.kh.spring.member.exception;

public class DuplcateIdException extends RuntimeException{
	
	public DuplcateIdException (String message) {
		super(message);
	}
}
