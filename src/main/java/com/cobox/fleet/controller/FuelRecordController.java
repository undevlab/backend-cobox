package com.cobox.fleet.controller;

import com.cobox.fleet.entity.FuelRecord;
import com.cobox.fleet.repository.FuelRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/fuel-records")
@CrossOrigin(allowedHeaders = "*", allowCredentials = "false")
public class FuelRecordController {

    @Autowired
    private FuelRecordRepository fuelRecordRepository;

    @GetMapping
    public ResponseEntity<List<FuelRecord>> getAllFuelRecords() {
        List<FuelRecord> fuelRecords = fuelRecordRepository.findAll();
        return ResponseEntity.ok(fuelRecords);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuelRecord> getFuelRecordById(@PathVariable String id) {
        Optional<FuelRecord> fuelRecord = fuelRecordRepository.findById(id);
        return fuelRecord.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/vehicle/{vehicleId}")
    public ResponseEntity<List<FuelRecord>> getFuelRecordsByVehicleId(@PathVariable Long vehicleId) {
        List<FuelRecord> fuelRecords = fuelRecordRepository.findByVehicleIdOrderByDateDesc(vehicleId);
        return ResponseEntity.ok(fuelRecords);
    }

    @GetMapping("/plate/{vehiclePlate}")
    public ResponseEntity<List<FuelRecord>> getFuelRecordsByVehiclePlate(@PathVariable String vehiclePlate) {
        List<FuelRecord> fuelRecords = fuelRecordRepository.findByVehiclePlateOrderByDateDesc(vehiclePlate);
        return ResponseEntity.ok(fuelRecords);
    }

    @GetMapping("/date-range")
    public ResponseEntity<List<FuelRecord>> getFuelRecordsByDateRange(
            @RequestParam String startDate,
            @RequestParam String endDate) {
        try {
            LocalDateTime start = LocalDateTime.parse(startDate);
            LocalDateTime end = LocalDateTime.parse(endDate);
            List<FuelRecord> fuelRecords = fuelRecordRepository.findByDateBetweenOrderByDateDesc(start, end);
            return ResponseEntity.ok(fuelRecords);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<FuelRecord> createFuelRecord(@RequestBody FuelRecord fuelRecord) {
        try {
            FuelRecord savedFuelRecord = fuelRecordRepository.save(fuelRecord);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedFuelRecord);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuelRecord> updateFuelRecord(@PathVariable String id, @RequestBody FuelRecord fuelRecordDetails) {
        Optional<FuelRecord> optionalFuelRecord = fuelRecordRepository.findById(id);
        
        if (optionalFuelRecord.isPresent()) {
            FuelRecord fuelRecord = optionalFuelRecord.get();
            
            // Update all fields
            fuelRecord.setVehicleId(fuelRecordDetails.getVehicleId());
            fuelRecord.setVehiclePlate(fuelRecordDetails.getVehiclePlate());
            fuelRecord.setDate(fuelRecordDetails.getDate());
            fuelRecord.setFuelType(fuelRecordDetails.getFuelType());
            fuelRecord.setQuantity(fuelRecordDetails.getQuantity());
            fuelRecord.setTotalCost(fuelRecordDetails.getTotalCost());
            fuelRecord.setCurrentMileage(fuelRecordDetails.getCurrentMileage());
            fuelRecord.setStation(fuelRecordDetails.getStation());
            fuelRecord.setLocation(fuelRecordDetails.getLocation());
            fuelRecord.setInvoiceNumber(fuelRecordDetails.getInvoiceNumber());
            fuelRecord.setNotes(fuelRecordDetails.getNotes());
            
            FuelRecord updatedFuelRecord = fuelRecordRepository.save(fuelRecord);
            return ResponseEntity.ok(updatedFuelRecord);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFuelRecord(@PathVariable String id) {
        if (fuelRecordRepository.existsById(id)) {
            fuelRecordRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}