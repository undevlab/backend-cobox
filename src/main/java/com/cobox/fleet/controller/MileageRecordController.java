package com.cobox.fleet.controller;

import com.cobox.fleet.entity.MileageRecord;
import com.cobox.fleet.repository.MileageRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/mileage-records")
@CrossOrigin(allowedHeaders = "*", allowCredentials = "false")
public class MileageRecordController {

    @Autowired
    private MileageRecordRepository mileageRecordRepository;

    @GetMapping
    public ResponseEntity<List<MileageRecord>> getAllMileageRecords() {
        List<MileageRecord> mileageRecords = mileageRecordRepository.findAll();
        return ResponseEntity.ok(mileageRecords);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MileageRecord> getMileageRecordById(@PathVariable String id) {
        Optional<MileageRecord> mileageRecord = mileageRecordRepository.findById(id);
        return mileageRecord.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/vehicle/{vehicleId}")
    public ResponseEntity<List<MileageRecord>> getMileageRecordsByVehicleId(@PathVariable String vehicleId) {
        List<MileageRecord> mileageRecords = mileageRecordRepository.findByVehicleIdOrderByDateDesc(vehicleId);
        return ResponseEntity.ok(mileageRecords);
    }

    @GetMapping("/date-range")
    public ResponseEntity<List<MileageRecord>> getMileageRecordsByDateRange(
            @RequestParam String startDate,
            @RequestParam String endDate) {
        try {
            LocalDateTime start = LocalDateTime.parse(startDate);
            LocalDateTime end = LocalDateTime.parse(endDate);
            List<MileageRecord> mileageRecords = mileageRecordRepository.findByDateBetweenOrderByDateDesc(start, end);
            return ResponseEntity.ok(mileageRecords);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/purpose/{purpose}")
    public ResponseEntity<List<MileageRecord>> getMileageRecordsByPurpose(@PathVariable String purpose) {
        List<MileageRecord> mileageRecords = mileageRecordRepository.findByPurpose(purpose);
        return ResponseEntity.ok(mileageRecords);
    }

    @GetMapping("/driver/{driverId}")
    public ResponseEntity<List<MileageRecord>> getMileageRecordsByDriverId(@PathVariable String driverId) {
        List<MileageRecord> mileageRecords = mileageRecordRepository.findByDriverId(driverId);
        return ResponseEntity.ok(mileageRecords);
    }

    @PostMapping
    public ResponseEntity<MileageRecord> createMileageRecord(@RequestBody MileageRecord mileageRecord) {
        try {
            // Auto-set creation timestamp if not provided
            if (mileageRecord.getCreatedAt() == null) {
                mileageRecord.setCreatedAt(LocalDateTime.now());
            }
            
            // Auto-calculate distance if not provided
            if (mileageRecord.getDistance() == null && 
                mileageRecord.getStartOdometer() != null && 
                mileageRecord.getEndOdometer() != null) {
                mileageRecord.setDistance(
                    mileageRecord.getEndOdometer().subtract(mileageRecord.getStartOdometer())
                );
            }
            
            MileageRecord savedMileageRecord = mileageRecordRepository.save(mileageRecord);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedMileageRecord);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<MileageRecord> updateMileageRecord(@PathVariable String id, @RequestBody MileageRecord mileageRecordDetails) {
        Optional<MileageRecord> optionalMileageRecord = mileageRecordRepository.findById(id);
        
        if (optionalMileageRecord.isPresent()) {
            MileageRecord mileageRecord = optionalMileageRecord.get();
            
            // Update all fields
            mileageRecord.setVehicleId(mileageRecordDetails.getVehicleId());
            mileageRecord.setDate(mileageRecordDetails.getDate());
            mileageRecord.setStartOdometer(mileageRecordDetails.getStartOdometer());
            mileageRecord.setEndOdometer(mileageRecordDetails.getEndOdometer());
            mileageRecord.setDistance(mileageRecordDetails.getDistance());
            mileageRecord.setPurpose(mileageRecordDetails.getPurpose());
            mileageRecord.setRoute(mileageRecordDetails.getRoute());
            mileageRecord.setDriverId(mileageRecordDetails.getDriverId());
            mileageRecord.setNotes(mileageRecordDetails.getNotes());
            mileageRecord.setCreatedBy(mileageRecordDetails.getCreatedBy());
            
            // Re-calculate distance if odometer values changed
            if (mileageRecord.getStartOdometer() != null && mileageRecord.getEndOdometer() != null) {
                mileageRecord.setDistance(
                    mileageRecord.getEndOdometer().subtract(mileageRecord.getStartOdometer())
                );
            }
            
            MileageRecord updatedMileageRecord = mileageRecordRepository.save(mileageRecord);
            return ResponseEntity.ok(updatedMileageRecord);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMileageRecord(@PathVariable String id) {
        if (mileageRecordRepository.existsById(id)) {
            mileageRecordRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}