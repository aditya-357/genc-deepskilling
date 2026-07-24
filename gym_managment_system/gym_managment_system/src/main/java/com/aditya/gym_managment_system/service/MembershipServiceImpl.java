package com.aditya.gym_managment_system.service;

import com.aditya.gym_managment_system.dto.MembershipResponse;
import com.aditya.gym_managment_system.entity.*;
import com.aditya.gym_managment_system.exception.ResourceNotFoundException;
import com.aditya.gym_managment_system.repository.MemberRepository;
import com.aditya.gym_managment_system.repository.MembershipRepository;
import com.aditya.gym_managment_system.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembershipServiceImpl implements MembershipService {

    @Autowired
    MembershipRepository membershipRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    PlanRepository planRepository;


    @Override
    public MembershipResponse createMembership(Membership membership){

        Member member = memberRepository.findById(membership.getMember().getId()).orElseThrow(()-> new RuntimeException("member not found"));
        Plan plan = planRepository.findById(membership.getPlan().getId()).orElseThrow(() -> new  RuntimeException("plan not found"));

        membership.setMember(member);
        membership.setPlan(plan);

        Membership saved= membershipRepository.save(membership);

        return mapToResponse(membership);

    }


    public MembershipResponse mapToResponse(Membership m){
        return new MembershipResponse(
                m.getId(),
                m.getMember().getId(),
                m.getMember().getName(),
                m.getPlan().getId(),
                m.getPlan().getPlanName(),
                m.getStartDate(),
                m.getEndDate(),
                m.getPaidAmount(),
                m.getDueAmount(),
                m.getStatus()
        );
    }



    @Override
    public List<MembershipResponse> getAllMemberships(){
        return membershipRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();

    }


    @Override
    public MembershipResponse getMembershipById(Long id) {
        Membership membership = membershipRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Membership not found with id: " + id));
        return mapToResponse(membership);
    }

    @Override
    public MembershipResponse updateMembership(Long id, Membership membership){
        Membership existing =  membershipRepository.findById(id).orElseThrow(()-> new RuntimeException("no membership with found of id "+ id));

        existing.setStartDate(membership.getStartDate());
        existing.setEndDate(membership.getEndDate());
        existing.setPaidAmount(membership.getPaidAmount());
        existing.setDueAmount(membership.getDueAmount());
        existing.setStatus(membership.getStatus());

        Membership saved = membershipRepository.save(existing);

        return mapToResponse(saved);
    }


    @Override

    public void deleteMembership(Long id){
        membershipRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("no membership with this id"+id));

        membershipRepository.deleteById(id);
    }



}
