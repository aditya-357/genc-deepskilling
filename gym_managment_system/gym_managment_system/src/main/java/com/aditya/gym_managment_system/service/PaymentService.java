package com.aditya.gym_managment_system.service;
import com.aditya.gym_managment_system.dto.PaymentResponse;
import com.aditya.gym_managment_system.entity.Payment;

import java.util.List;

public interface PaymentService {

    PaymentResponse createPayment(Payment payment);
    List<PaymentResponse> getAllPayments();
    List<PaymentResponse> getPaymentsByMember(Long memberId);
}
