package com.example.hellospring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.example.hellospring.domain.Member;
import com.example.hellospring.repository.MemberRepository;

@Transactional
public class MemberService {
	
	/**
	 * memberRepository : 실제 구현체를 가져와야 함.
	 */
	// private final MemberRepository memberRepository = new MemoryMemberRepository();
	private final MemberRepository memberRepository;
	
	public MemberService(MemberRepository memberRepository) {
		
		this.memberRepository = memberRepository;
	}
	
	/**
	 * 회원가입
	 * 
	 * @param member
	 * @return
	 */
	public Long join(Member member) {
			
		// 중복회원 검증
		validateDuplicateMember(member);
			
		memberRepository.save(member);
			
		return member.getId();
	}

	/**
	 * 회원조회 : 전체
	 * 
	 * @return
	 */
	public List<Member> findMembers() {
		
		return memberRepository.findAll();
	}
	
	/**
	 * 회원조회 : id
	 * 
	 * @param memberId
	 * @return
	 */
	public Optional<Member> findOne(Long memberId) {
		
		return memberRepository.findById(memberId);
	}
	
	/**
	 * 중복회원 검증
	 * 
	 * @param member
	 */
	private void validateDuplicateMember(Member member) {

		// memberRepository.findByName(member.getName()).ifPresent(m -> {throw new IllegalStateException("이미 존재하는 회원입니다.");});
		memberRepository.findByName(member.getName()).ifPresent(m -> {throw new IllegalStateException(member.getName());});
	}
}