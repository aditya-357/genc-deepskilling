package com.aditya.gym_managment_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aditya.gym_managment_system.entity.Plan;


@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {
}
