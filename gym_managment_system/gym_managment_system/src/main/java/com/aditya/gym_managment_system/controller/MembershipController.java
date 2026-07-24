package com.aditya.gym_managment_system.controller;


import com.aditya.gym_managment_system.dto.MembershipResponse;
import com.aditya.gym_managment_system.entity.Membership;
import com.aditya.gym_managment_system.service.MembershipService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/memberships")

public class MembershipController {

    private final MembershipService membershipService;

    public MembershipController(MembershipService membershipService){
        this.membershipService = membershipService;
    }


    @PostMapping
    public MembershipResponse createMembership(@RequestBody Membership membership) {
        return membershipService.createMembership(membership);
    }

    @GetMapping
    public List<MembershipResponse> getAllMemberships() {
        return membershipService.getAllMemberships();
    }

    @GetMapping("/{id}")
    public MembershipResponse getMembershipById(@PathVariable Long id) {
        return membershipService.getMembershipById(id);
    }

    @PutMapping("/{id}")
    public MembershipResponse updateMembership(@PathVariable Long id, @RequestBody Membership membership) {
        return membershipService.updateMembership(id, membership);
    }

    @DeleteMapping("/{id}")
    public void deleteMembership(@PathVariable Long id) {
        membershipService.deleteMembership(id);
    }


}
