package com.example.hellospring.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.hellospring.domain.Member;

public class MemoryMemberRepository implements MemberRepository {

	// Map(Memory) 임시 저장
	private static Map<Long, Member> store = new HashMap<>();
	
	// 시퀀스(회원 id)
	private static long sequence = 0L;
	
	/**
	 * 회원등록
	 * 
	 * @param member
	 * @return
	 */
	@Override
	public Member save(Member member) {
		
		member.setId(++sequence);
		
		store.put(member.getId(), member);
		
		return member;
	}

	/**
	 * 회원조회 : id
	 * 
	 * @param id
	 * @return
	 */	
	@Override
	public Optional<Member> findById(Long id) {

		return Optional.ofNullable(store.get(id));
	}
	
	/**
	 * 회원조회 : name
	 * 
	 * @param name
	 * @return
	 */	
	@Override
	public Optional<Member> findByName(String name) {
		
		return store.values().stream().filter(member -> member.getName().equals(name)).findAny();
	}

	/**
	 * 회원조회 : 전체 
	 * 
	 * @return
	 */
	@Override
	public List<Member> findAll() {
		
		// return new ArrayList<>(store.values());
		
		return new ArrayList<Member>(store.values());
	}
	
	/**
	 * map clear함수
	 */
	public void cleareStore() {
		
		store.clear();
	}
}