package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class MemberController {
	@Autowired
    private MemberService memberService;

    // 멤버 등록 (spring-data-jpa)
    @PostMapping(value = "/member")
    public String createMember(@RequestBody Member member){
        return memberService.createMember(member);
    }

    // 멤버 등록 (jpa EntityManager)
    @PostMapping(value = "/memberjpa")
    public String createMemberJpa(@RequestBody Member member){
        return memberService.createMemberJpa(member);
    }

    // 멤버 조회
    @GetMapping(value = "/member")
    public List<Member> getMember(@RequestParam(required = false, defaultValue = "") String name){
        return memberService.getMemberList(name);
    }
}