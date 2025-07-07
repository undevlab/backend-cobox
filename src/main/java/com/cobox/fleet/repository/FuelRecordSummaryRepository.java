package com.cobox.fleet.repository;

import com.cobox.fleet.entity.FuelRecordSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FuelRecordSummaryRepository extends JpaRepository<FuelRecordSummary, String> {
    Optional<FuelRecordSummary> findByServiceId(String serviceId);
    List<FuelRecordSummary> findByPlatesContaining(String plate);
}