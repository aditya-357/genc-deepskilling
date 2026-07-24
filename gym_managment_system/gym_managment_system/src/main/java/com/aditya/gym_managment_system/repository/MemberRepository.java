package com.aditya.gym_managment_system.repository;

import com.aditya.gym_managment_system.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    long countByStatus(String status);
}
