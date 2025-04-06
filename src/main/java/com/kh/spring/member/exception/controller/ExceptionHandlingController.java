package com.kh.spring.member.exception.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.kh.spring.member.exception.InvaildException;
import com.kh.spring.member.exception.MemberNotFoundException;
import com.kh.spring.member.exception.SignUpException;

@ControllerAdvice
public class ExceptionHandlingController {

	
	
	@ExceptionHandler(MemberNotFoundException.class)
	public ResponseEntity<?> handleNotFoundError(MemberNotFoundException e) {
		
		Map<String, String> error = new HashMap();
		error.put("message", e.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		
	} 
	
	@ExceptionHandler(InvaildException.class)
	public ResponseEntity<?> handleInvaildError(InvaildException e){
		Map<String, String> error = new HashMap();
		error.put("message", e.getMessage());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
	@ExceptionHandler
	public ResponseEntity<?> handleSignUpError(SignUpException e) {
		Map<String,String> error = new HashMap();
		error.put("message",e.getMessage());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
	
}