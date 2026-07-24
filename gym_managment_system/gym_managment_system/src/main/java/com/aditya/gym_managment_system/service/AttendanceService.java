package com.aditya.gym_managment_system.service;

import com.aditya.gym_managment_system.dto.AttendanceResponse;
import com.aditya.gym_managment_system.entity.Attendance;

import java.util.List;



public interface AttendanceService {

    AttendanceResponse markAttendance(Attendance attendance);
    List<AttendanceResponse> getAllAttendance();
    List<AttendanceResponse> getAttendanceByMember(Long memberId);

}
