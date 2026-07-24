package com.aditya.gym_managment_system.service;


import com.aditya.gym_managment_system.dto.AttendanceResponse;
import com.aditya.gym_managment_system.entity.Attendance;
import com.aditya.gym_managment_system.entity.Member;
import com.aditya.gym_managment_system.exception.ResourceNotFoundException;
import com.aditya.gym_managment_system.repository.AttendanceRepository;
import com.aditya.gym_managment_system.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService{

    private final AttendanceRepository attendanceRepository;
    private final MemberRepository memberRepository;

    public AttendanceServiceImpl(AttendanceRepository attendanceRepository,
                                 MemberRepository memberRepository) {
        this.attendanceRepository = attendanceRepository;
        this.memberRepository = memberRepository;
    }

    @Override
    public AttendanceResponse markAttendance(Attendance attendance) {
        Member member = memberRepository.findById(attendance.getMember().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Member not found"));

        attendance.setMember(member);
        attendance.setLoginTime(LocalDateTime.now());
        attendance.setDate(LocalDate.now());

        Attendance saved = attendanceRepository.save(attendance);
        return mapToResponse(saved);
    }

    private AttendanceResponse mapToResponse(Attendance a) {
        return new AttendanceResponse(
                a.getId(),
                a.getMember().getId(),
                a.getMember().getName(),
                a.getLoginTime(),
                a.getDate(),
                a.getStatus()
        );
    }

    @Override
    public List<AttendanceResponse> getAllAttendance() {
        return attendanceRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public List<AttendanceResponse> getAttendanceByMember(Long memberId) {
        return attendanceRepository.findAll()
                .stream()
                .filter(a -> a.getMember().getId().equals(memberId))
                .map(this::mapToResponse)
                .toList();
    }

}
