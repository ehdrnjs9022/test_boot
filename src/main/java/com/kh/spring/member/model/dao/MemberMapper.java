package com.kh.spring.member.model.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.kh.spring.member.model.dto.MemberDTO;

@Mapper 
public interface MemberMapper {
	
	@Select("SELECT MEMBER_ID, MEMBER_PW , MEMBER_NAME, MEMBER, EMAIL, "
			+ "	ENROLL_DATE FROM HOME_MEMBER WHERE MEMBER_ID= #{memberId} AND MEMBER_PW=#{memberPw}")
	MemberDTO login(MemberDTO member);
	@Insert("INSERT INTO HOME_MEMBER VALUES (#{memberId},#{memberPw},#{memberName},#{email}, SYSDATE)")
	MemberDTO signUp(MemberDTO member);
	
	void CheckId(MemberDTO member);
}
