package com.aditya.gym_managment_system.repository;
import com.aditya.gym_managment_system.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AttendanceRepository  extends  JpaRepository< Attendance, Long>{

    long countByDate(java.time.LocalDate date);
}
