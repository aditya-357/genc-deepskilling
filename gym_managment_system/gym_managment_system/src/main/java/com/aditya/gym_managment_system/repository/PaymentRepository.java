package com.aditya.gym_managment_system.repository;

import com.aditya.gym_managment_system.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository  extends JpaRepository<Payment,Long>{
}
