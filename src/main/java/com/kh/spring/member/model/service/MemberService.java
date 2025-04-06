package com.kh.spring.member.model.service;

import com.kh.spring.member.model.dto.MemberDTO;

import jakarta.servlet.http.HttpSession;

public interface MemberService {

	MemberDTO login(MemberDTO member,  HttpSession session);
	
	MemberDTO signUp(MemberDTO member);


	
	
}	
