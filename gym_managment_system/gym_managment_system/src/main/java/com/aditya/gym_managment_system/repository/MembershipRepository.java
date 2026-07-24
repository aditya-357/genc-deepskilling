package com.aditya.gym_managment_system.repository;

import com.aditya.gym_managment_system.entity.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface MembershipRepository extends  JpaRepository< Membership , Long> {

    long countByStatus(String status);
}
