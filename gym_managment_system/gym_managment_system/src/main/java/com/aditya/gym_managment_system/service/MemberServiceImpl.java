package com.aditya.gym_managment_system.service;


import com.aditya.gym_managment_system.exception.ResourceNotFoundException;
import com.aditya.gym_managment_system.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import com.aditya.gym_managment_system.service.MemberService;
import com.aditya.gym_managment_system.entity.Member;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository= memberRepository;
    }


    @Override
    public Member createMember(Member member){
        member.setJoiningDate(LocalDate.now());
        return memberRepository.save(member);
    }

    @Override
    public List<Member> getAllMember(){
        return memberRepository.findAll();
    }


    @Override
    public Member getMemberById(Long id){
        return memberRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("member not found " + id));
    }

    @Override
    public Member updateMember(Long id , Member member){
        Member existingMember = getMemberById(id);
        existingMember.setName(member.getName());
        existingMember.setEmail(member.getEmail());
        existingMember.setGender(member.getGender());
        existingMember.setAddress(member.getAddress());
        existingMember.setPhone(member.getPhone());
        existingMember.setStatus(member.getStatus());
        existingMember.setPhotoUrl(member.getPhotoUrl());
        existingMember.setJoiningDate(member.getJoiningDate());
     return memberRepository.save(member);
    }

    @Override
    public void deleteMember(Long id){
        getMemberById(id);
        memberRepository.deleteById(id);
    }


}
