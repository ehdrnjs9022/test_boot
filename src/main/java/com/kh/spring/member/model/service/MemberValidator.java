package com.kh.spring.member.model.service;


import java.security.InvalidParameterException;

import org.springframework.stereotype.Component;

import com.kh.spring.member.exception.DuplcateIdException;
import com.kh.spring.member.exception.MemberNotFoundException;
import com.kh.spring.member.model.dao.MemberMapper;
import com.kh.spring.member.model.dto.MemberDTO;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MemberValidator {
	
	private final MemberMapper mapper;
	
	public void InvalidValue(MemberDTO member) {
		if(member == null || 
				member.getMemberId() == null||
				member.getMemberId().trim().isEmpty()||
				member.getMemberPw() == null ||
				member.getMemberPw().trim().isEmpty()) {
			throw new InvalidParameterException("유효하지 않은 입력값 입니다");
		}
	}
	
		public MemberDTO validateMemberExists(MemberDTO member) {
			MemberDTO loginMember = mapper.login(member);
			
			if(loginMember != null) {
			return loginMember;
			}		
			throw new MemberNotFoundException("존재하지 않는 아이디입니다.");
			
	
	}
		public MemberDTO DuplicateException(MemberDTO member) {
			MemberDTO signUpMember = mapper.signUp(member);
			if(signUpMember != null && member.getMemberId().equals(signUpMember.getMemberId()))
				throw new DuplcateIdException("이미 존재하는 아이디입니다");
			return signUpMember;
		}
	
	
	
	
}
