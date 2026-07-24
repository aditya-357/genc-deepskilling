package com.aditya.gym_managment_system.dto;

import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AttendanceResponse {

    private Long id;
    private Long memberId;
    private String memberName;
    private LocalDateTime loginTime;
    private LocalDate date;
    private String status;


}
