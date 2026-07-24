package com.aditya.gym_managment_system.service;

import com.aditya.gym_managment_system.dto.MembershipResponse;
import com.aditya.gym_managment_system.entity.Membership;

import java.util.List;

public interface MembershipService {

    MembershipResponse createMembership(Membership membership);
    List<MembershipResponse> getAllMemberships();
    MembershipResponse getMembershipById(Long id);
    MembershipResponse updateMembership(Long id, Membership membership);
    void deleteMembership(Long id);

}
