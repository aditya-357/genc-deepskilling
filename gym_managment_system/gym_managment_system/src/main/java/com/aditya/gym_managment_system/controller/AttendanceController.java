package com.aditya.gym_managment_system.controller;

import com.aditya.gym_managment_system.dto.AttendanceResponse;
import com.aditya.gym_managment_system.entity.Attendance;
import com.aditya.gym_managment_system.service.AttendanceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {


    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @PostMapping
    public AttendanceResponse markAttendance(@RequestBody Attendance attendance) {
        return attendanceService.markAttendance(attendance);
    }

    @GetMapping
    public List<AttendanceResponse> getAllAttendance() {
        return attendanceService.getAllAttendance();
    }

    @GetMapping("/member/{memberId}")
    public List<AttendanceResponse> getAttendanceByMember(@PathVariable Long memberId) {
        return attendanceService.getAttendanceByMember(memberId);
    }
}
