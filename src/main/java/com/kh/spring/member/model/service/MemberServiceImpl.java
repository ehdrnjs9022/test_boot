package com.kh.spring.member.model.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.spring.member.exception.PasswordNotmathchException;
import com.kh.spring.member.exception.SignUpException;
import com.kh.spring.member.model.dao.MemberMapper;
import com.kh.spring.member.model.dto.MemberDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

		private final MemberMapper mapper;
		private final MemberValidator validator;
		private final PasswordEncoder passwordEncoder;
		
		@Override
		public MemberDTO login(MemberDTO member) {
			
			validator.InvalidValue(member);
			
	    	MemberDTO loginMember = validator.validateMemberExists(member);
	    	
	        if (passwordEncoder.matches(member.getMemberPw(), loginMember.getMemberPw())) {
	            return loginMember;
	        } else {
	            throw new PasswordNotmathchException("비밀번호가 일치하지 않습니다");
	        }
		}
	// --------------------------------------------------------------------
		@Override
		public MemberDTO signUp(MemberDTO member) {
			
			validator.DuplicateException(member);
			member.setMemberPw(passwordEncoder.encode(member.getMemberPw()));
			MemberDTO result = mapper.signUp(member);
			if(result !=null) {
			
			} else {
				throw new SignUpException("회원가입 실패");
			}
				return result;
		}
	
}	