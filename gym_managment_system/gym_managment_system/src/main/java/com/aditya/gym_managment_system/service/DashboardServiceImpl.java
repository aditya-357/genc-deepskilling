package com.aditya.gym_managment_system.service;


import com.aditya.gym_managment_system.dto.DashboardResponse;
import com.aditya.gym_managment_system.repository.AttendanceRepository;
import com.aditya.gym_managment_system.repository.MemberRepository;
import com.aditya.gym_managment_system.repository.MembershipRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DashboardServiceImpl  implements  DashboardService{


    private final MemberRepository memberRepository;
    private final MembershipRepository membershipRepository;
    private final AttendanceRepository attendanceRepository;

    public DashboardServiceImpl(MemberRepository memberRepository,
                                MembershipRepository membershipRepository,
                                AttendanceRepository attendanceRepository) {
        this.memberRepository = memberRepository;
        this.membershipRepository = membershipRepository;
        this.attendanceRepository = attendanceRepository;
    }

    @Override
    public DashboardResponse getDashboardStats() {
        long totalMembers = memberRepository.count();
        long activeMembers = memberRepository.countByStatus("ACTIVE");
        long todayAttendance = attendanceRepository.countByDate(LocalDate.now());
        long expiredMemberships = membershipRepository.countByStatus("EXPIRED");

        return new DashboardResponse(totalMembers, activeMembers, todayAttendance, expiredMemberships);
    }
}
