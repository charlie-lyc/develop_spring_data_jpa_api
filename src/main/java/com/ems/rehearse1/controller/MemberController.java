package com.ems.rehearse1.controller;

import com.ems.rehearse1.domain.Member;
import com.ems.rehearse1.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * 4. Fourth
 *  - @RestController: rest api
 *  - @Controller : template engine
 */
@RestController
public class MemberController {

    private final MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

//    @GetMapping("/")
//    public String hello() {
//        return "This is the Spring Framework.";
//    }

    @PostMapping("/member")
    public Member createMember(@RequestBody Member member) {
        return memberService.signup(member);
    }

    @GetMapping("/member/{id}")
    public Optional<Member> getMemberById(@PathVariable long id) {
        return memberService.findMemberById(id);
    }

    @GetMapping("/members")
    public List<Member> getAllMembers() {
        return memberService.findAllMembers();
    }

    @GetMapping("/member")
    public Optional<Member> getMemberByName(@RequestParam String name) {
        return memberService.findMemberByName(name);
    }

}
