package com.aditya.gym_managment_system.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "membership")

public class Membership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id" , nullable = false)
    private Member member;


    @ManyToOne
    @JoinColumn(name ="plan_id", nullable = false)
    private Plan plan;


    private LocalDate startDate;

    private LocalDate endDate;

    private Double paidAmount;

    private Double dueAmount;

    private String status;


}
