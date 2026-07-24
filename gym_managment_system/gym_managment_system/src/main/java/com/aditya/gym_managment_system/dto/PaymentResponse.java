package com.aditya.gym_managment_system.dto;

import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponse {
    private Long id;
    private Long membershipId;
    private String memberName;   // pulled from membership.getMember().getName()
    private Double amount;
    private String paymentMode;
    private LocalDate paymentDate;
    private String transactionId;

}

