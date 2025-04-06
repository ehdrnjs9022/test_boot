package com.kh.spring.member.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring.member.model.dto.MemberDTO;
import com.kh.spring.member.model.service.MemberService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("members")
@CrossOrigin(origins="*")
public class MemberController {

	private final MemberService memberService;
	 
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody MemberDTO member , HttpSession session) {
		
		MemberDTO loginMember = memberService.login(member, session);
		session.setAttribute("loginMember", loginMember);
		return ResponseEntity.ok(loginMember);
	
	}
	
	@PostMapping("/signup")
	public MemberDTO singup(@RequestBody MemberDTO member) {
		
		MemberDTO result = memberService.signUp(member);

		return result;
	}
	
	@PostMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok("로그아웃 성공");
    }
	
	
	
}
	