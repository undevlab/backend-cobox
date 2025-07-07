package com.cobox.fleet.controller;

import com.cobox.fleet.entity.FuelRecordSummary;
import com.cobox.fleet.repository.FuelRecordSummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/fuel-records-summary")
@CrossOrigin(allowedHeaders = "*", allowCredentials = "false")
public class FuelRecordSummaryController {

    @Autowired
    private FuelRecordSummaryRepository fuelRecordSummaryRepository;

    @GetMapping
    public ResponseEntity<List<FuelRecordSummary>> getAllFuelRecordSummaries() {
        List<FuelRecordSummary> summaries = fuelRecordSummaryRepository.findAll();
        return ResponseEntity.ok(summaries);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuelRecordSummary> getFuelRecordSummaryById(@PathVariable String id) {
        Optional<FuelRecordSummary> summary = fuelRecordSummaryRepository.findById(id);
        return summary.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<FuelRecordSummary> createFuelRecordSummary(@RequestBody FuelRecordSummary summary) {
        try {
            FuelRecordSummary savedSummary = fuelRecordSummaryRepository.save(summary);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedSummary);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuelRecordSummary> updateFuelRecordSummary(@PathVariable String id, @RequestBody FuelRecordSummary summaryDetails) {
        Optional<FuelRecordSummary> optionalSummary = fuelRecordSummaryRepository.findById(id);
        
        if (optionalSummary.isPresent()) {
            FuelRecordSummary summary = optionalSummary.get();
            summary.setServiceId(summaryDetails.getServiceId());
            summary.setTotalRecords(summaryDetails.getTotalRecords());
            summary.setInitialDate(summaryDetails.getInitialDate());
            summary.setFinalDate(summaryDetails.getFinalDate());
            summary.setTotalFuel(summaryDetails.getTotalFuel());
            summary.setPlates(summaryDetails.getPlates());
            
            FuelRecordSummary updatedSummary = fuelRecordSummaryRepository.save(summary);
            return ResponseEntity.ok(updatedSummary);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFuelRecordSummary(@PathVariable String id) {
        if (fuelRecordSummaryRepository.existsById(id)) {
            fuelRecordSummaryRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}