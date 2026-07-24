package com.aditya.gym_managment_system.dto;


import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MembershipResponse {

    private Long id;
    private Long memberId;
    private String memberName;
    private Long planId;
    private String planName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double paidAmount;
    private Double dueAmount;
    private String status;


}
