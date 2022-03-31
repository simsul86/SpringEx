package com.example.hellospring.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.example.hellospring.domain.Member;

public class MemoryMemberRepositoryTest {

	MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
	
	@AfterEach
	public void afterEach() {
		
		// 테스트는 각각 독립적으로 실행이 되어야 한다.
		// 테스트시에는 DB에 저장된 데이터 삭제 처리 후 다른 테스트 진행
		memoryMemberRepository.cleareStore();
	}
	
	@Test
	public void save() {
		
		// given
		Member member = new Member();
		member.setName("spring");
		
		// when
		Member resultMemberSave = memoryMemberRepository.save(member);
		System.out.println("resultMemberSaveId ::: {}" + resultMemberSave.getId());
		System.out.println("resultMemberSaveName ::: {}" + resultMemberSave.getName());
		
		// then
		Member resultMember = memoryMemberRepository.findById(member.getId()).get();
		System.out.println("resultMember ::: {}" + resultMember.getId());
		
		assertThat(resultMember).isEqualTo(member);
	}
	
	@Test
	public void findByName() {
		
		// given
		Member member1 = new Member();
		member1.setName("spring1");
		memoryMemberRepository.save(member1);
		
		Member member2 = new Member();
		member2.setName("spring2");
		memoryMemberRepository.save(member2);
		
		// when
		Member resultMember = memoryMemberRepository.findByName("spring1").get();
		System.out.println("resultMemberName ::: " + resultMember.getName());
		
		// then
		assertThat(resultMember).isEqualTo(member1);
	}
	
	@Test
	public void findAll() {
		
		// given
		Member member1 = new Member();
		member1.setName("spring1");
		memoryMemberRepository.save(member1);
		
		Member member2 = new Member();
		member2.setName("spring2");
		memoryMemberRepository.save(member2);
		
		// when
		List<Member> result = memoryMemberRepository.findAll();
		
		// then
		assertThat(result.size()).isEqualTo(2);		
	}
}