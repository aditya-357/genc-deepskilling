package com.aditya.gym_managment_system.service;

import com.aditya.gym_managment_system.entity.Member;

import java.util.List;

public interface MemberService {

    Member createMember(Member member);
    List<Member>  getAllMember();
    Member getMemberById(Long id);
    Member updateMember(Long id , Member member);
    void deleteMember(Long id);
}
