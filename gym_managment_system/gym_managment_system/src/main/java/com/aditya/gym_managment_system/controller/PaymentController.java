package com.aditya.gym_managment_system.controller;


import com.aditya.gym_managment_system.dto.PaymentResponse;
import com.aditya.gym_managment_system.entity.Payment;
import com.aditya.gym_managment_system.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {


    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public PaymentResponse createPayment(@RequestBody Payment payment) {
        return paymentService.createPayment(payment);
    }

    @GetMapping
    public List<PaymentResponse> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/member/{id}")
    public List<PaymentResponse> getPaymentsByMember(@PathVariable Long id) {
        return paymentService.getPaymentsByMember(id);
    }

}
