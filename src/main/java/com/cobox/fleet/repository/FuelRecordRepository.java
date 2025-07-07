package com.cobox.fleet.repository;

import com.cobox.fleet.entity.FuelRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FuelRecordRepository extends JpaRepository<FuelRecord, String> {
    List<FuelRecord> findByVehicleIdOrderByDateDesc(Long vehicleId);
    List<FuelRecord> findByVehiclePlateOrderByDateDesc(String vehiclePlate);
    List<FuelRecord> findByDateBetweenOrderByDateDesc(LocalDateTime startDate, LocalDateTime endDate);
}