package com.example.hellospring.repository;

import java.util.List;
import java.util.Optional;

import com.example.hellospring.domain.Member;

public interface MemberRepository {
	
	/**
	 * 회원등록
	 * 
	 * @param member
	 * @return
	 */
	public Member save(Member member);	
	
	/**
	 * 회원조회 : id
	 * 
	 * @param id
	 * @return
	 */
	public Optional<Member> findById(Long id);
	
	/**
	 * 회원조회 : name
	 * 
	 * @param name
	 * @return
	 */
	public Optional<Member> findByName(String name);
	
	/**
	 * 회원조회 : 전체 
	 * 
	 * @return
	 */
	public List<Member> findAll();
}