package com.example.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional(readOnly = true)
public class MemberCustomReposityImpl implements MemberCustomReposity {
	@PersistenceContext	// 영속성 컨택스트를 spring-data-jpa 에서 사용하기 위한 어노테이션
    EntityManager em;

	@Override
	@Transactional
    public String createUserAuto(Member member){
    	log.info(member.getName());
    	em.persist(member);

    	Member member2 = em.find(Member.class, member.getId());
       	log.info(member2.getName() + " / " + member2.getId());

    	return "실행 완료";
   }
}
