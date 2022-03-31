package com.example.hellospring.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.hellospring.domain.Member;
import com.example.hellospring.repository.MemberRepository;

@SpringBootTest
@Transactional
public class MemberServiceTest {
	
	@Autowired MemberService memberService;
	@Autowired MemberRepository MemberRepository;
	
	/**
	 * 회원가입 테스트 함수.
	 * 
	 * @throws Exception
	 */
	@Test
	public void 회원가입() throws Exception {
		
		// given
		Member member = new Member();
		member.setName("hello");
		
		// when
		Long saveId = memberService.join(member);
		
		// then
		Member findMember = memberService.findOne(saveId).get();
		
		assertEquals(member.getName(), findMember.getName());		
		
		System.out.println("member ::: " + member.getName());
		System.out.println("findMember ::: " + findMember.getName());
	}
	
	/**
	 * 주복회원 검증
	 * 
	 * @throws Exception
	 */
	@Test
	public void 중복회원검증() throws Exception {
		
		// given
		Member member1 = new Member();
		member1.setName("spring2");
		
		Member member2 = new Member();
		member2.setName("spring2");

		// when
		// memberService.join(member1);
		// IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
		// assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원 입니다.");
		// assertThat(e.getMessage()).isEqualTo(member1.getName());
		// System.out.println("e.getMessage() ::: " + e.getMessage());
		// System.out.println("member1.getName ::: " + member1.getName());
	}
}