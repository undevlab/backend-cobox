package com.cobox.fleet.repository;

import com.cobox.fleet.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, String> {
    List<Schedule> findByScheduleDate(String scheduleDate);
    List<Schedule> findByServiceDate(String serviceDate);
    List<Schedule> findByDriver(String driver);
    List<Schedule> findByPlate(String plate);
}