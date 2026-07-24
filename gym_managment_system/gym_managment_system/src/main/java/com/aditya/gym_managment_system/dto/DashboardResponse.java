package com.aditya.gym_managment_system.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class DashboardResponse {

    private long totalMembers;
    private long activeMembers;
    private long todayAttendance;
    private long expiredMemberships;


}
