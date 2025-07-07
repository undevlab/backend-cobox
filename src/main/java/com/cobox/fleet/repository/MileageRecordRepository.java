package com.cobox.fleet.repository;

import com.cobox.fleet.entity.MileageRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MileageRecordRepository extends JpaRepository<MileageRecord, String> {
    List<MileageRecord> findByVehicleIdOrderByDateDesc(String vehicleId);
    List<MileageRecord> findByDateBetweenOrderByDateDesc(LocalDateTime startDate, LocalDateTime endDate);
    List<MileageRecord> findByPurpose(String purpose);
    List<MileageRecord> findByDriverId(String driverId);
    List<MileageRecord> findByCreatedBy(String createdBy);
}