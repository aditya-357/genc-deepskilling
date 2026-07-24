package com.aditya.gym_managment_system.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "members")


public class Member {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "member id is required")
    @Column(unique = true , nullable = false)
    private String memberId;


    @NotBlank(message = "name is required")
    private String name;


    @NotBlank(message = "phone no. is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "phone no is required")
    private String phone;


    @Email(message = "email format is required")
    private String email;

    private String gender;

    private String address;

    private LocalDate joiningDate;


    @NotBlank(message = "Status is required ")
    private String status;

    private String photoUrl;

}
