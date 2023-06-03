package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

	@Autowired
    private MemberRepository memberRepository;

    // spring-data-jpa
    public String createMember(Member member){
    	memberRepository.save(member); // 사용자 등록 처리
        return "success";
    }

    // jpa
    public String createMemberJpa(Member member){
    	log.info("member name : " + member.getName());
    	memberRepository.createUserAuto(member);
    	return "jpa success";
	}

    public List<Member> getMemberList(String name){
        if(name.isEmpty()) {
            return memberRepository.findAll();
        } else {
        	return memberRepository.findByNameLikeOrderByName(name);
        }
    }
}