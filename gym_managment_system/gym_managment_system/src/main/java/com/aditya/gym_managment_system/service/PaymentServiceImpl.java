package com.aditya.gym_managment_system.service;

import com.aditya.gym_managment_system.dto.PaymentResponse;
import com.aditya.gym_managment_system.entity.Membership;
import com.aditya.gym_managment_system.entity.Payment;
import com.aditya.gym_managment_system.exception.ResourceNotFoundException;
import com.aditya.gym_managment_system.repository.MembershipRepository;
import com.aditya.gym_managment_system.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService{

    private final PaymentRepository paymentRepository;
    private final MembershipRepository membershipRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository,
                              MembershipRepository membershipRepository) {
        this.paymentRepository = paymentRepository;
        this.membershipRepository = membershipRepository;
    }



    @Override
    public PaymentResponse createPayment(Payment payment) {
        Membership membership = membershipRepository.findById(payment.getMembership().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Membership not found"));

        payment.setMembership(membership);
        payment.setPaymentDate(LocalDate.now());

        Payment saved = paymentRepository.save(payment);
        return mapToResponse(saved);
    }

    @Override
    public List<PaymentResponse> getAllPayments() {
        return paymentRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }


    @Override
    public List<PaymentResponse> getPaymentsByMember(Long memberId) {
        return paymentRepository.findAll()
                .stream()
                .filter(p -> p.getMembership().getMember().getId().equals(memberId))
                .map(this::mapToResponse)
                .toList();
    }

    private PaymentResponse mapToResponse(Payment p) {
        return new PaymentResponse(
                p.getId(),
                p.getMembership().getId(),
                p.getMembership().getMember().getName(),
                p.getAmount(),
                p.getPaymentMode(),
                p.getPaymentDate(),
                p.getTransactionId()
        );
    }


}
