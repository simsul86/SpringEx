package com.example.hellospring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.hellospring.domain.Member;
import com.example.hellospring.service.MemberService;

@Controller
public class MemberController {
	
	private final MemberService memberService;
	
	@Autowired
	public MemberController(MemberService memberService) {
		
		this.memberService = memberService;
	}
	
	/**
	 * home
	 * 
	 * @return
	 */
	@GetMapping("/")
	public String home() {
		
		return "home";
	}
	
	/**
	 * 회원정보 입력
	 * 
	 * @return
	 */
	@GetMapping("/members/new")
	public String createForm() {
		
		return "members/createMemberForm";
	}
	
	/**
	 * 회원등록
	 * 
	 * @param form
	 * @return
	 */
	@PostMapping("/members/new")
	public String create(MemberForm form) {
		
		Member member = new Member();
		
		member.setName(form.getName());
		
		memberService.join(member);
		
		return "redirect:/";
	}
	
	/**
	 * 회원조회
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/members")
	public String List(Model model) {
		
		List<Member> members = memberService.findMembers();
		
		model.addAttribute("members", members);
		
		return "/members/memberList";
	}
}