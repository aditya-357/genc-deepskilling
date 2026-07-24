package com.aditya.gym_managment_system.controller;

import com.aditya.gym_managment_system.entity.Member;
import com.aditya.gym_managment_system.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberContoller {

    private final MemberService memberService;

    public MemberContoller(MemberService memberService){
        this.memberService=memberService;
    }

    @PostMapping
    public Member createMember(@Valid @RequestBody  Member member){
         return memberService.createMember(member);
    }

    @GetMapping
    public List<Member>  getAllMember(){
        return memberService.getAllMember();
    }

    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable Long id){
        return memberService.getMemberById(id);
    }

    @PutMapping("/{id}")
    public Member updateMember(@PathVariable Long id, Member member){
        return memberService.updateMember(id, member);
    }

    @DeleteMapping("/{id}")
    public void deleteMember( @PathVariable Long id){
        memberService.deleteMember(id);
    }


}
