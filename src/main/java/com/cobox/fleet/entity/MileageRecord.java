package com.cobox.fleet.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "mileage_records")
public class MileageRecord {
    
    @Id
    private String id;
    
    @Column(name = "vehicle_id", nullable = false)
    private String vehicleId;
    
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
    @Column(nullable = false)
    private LocalDateTime date;
    
    @Column(name = "start_odometer", precision = 10, scale = 2, nullable = false)
    private BigDecimal startOdometer;
    
    @Column(name = "end_odometer", precision = 10, scale = 2, nullable = false)
    private BigDecimal endOdometer;
    
    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal distance;
    
    @Column(nullable = false)
    private String purpose;
    
    @Column(length = 500)
    private String route;
    
    @Column(name = "driver_id", nullable = false)
    private String driverId;
    
    @Column(length = 500)
    private String notes;
    
    @Column(name = "created_by", nullable = false)
    private String createdBy;
    
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    
    // Constructors
    public MileageRecord() {}
    
    public MileageRecord(String id, String vehicleId, LocalDateTime date, BigDecimal startOdometer,
                        BigDecimal endOdometer, BigDecimal distance, String purpose, String route,
                        String driverId, String notes, String createdBy, LocalDateTime createdAt) {
        this.id = id;
        this.vehicleId = vehicleId;
        this.date = date;
        this.startOdometer = startOdometer;
        this.endOdometer = endOdometer;
        this.distance = distance;
        this.purpose = purpose;
        this.route = route;
        this.driverId = driverId;
        this.notes = notes;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }
    
    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getVehicleId() { return vehicleId; }
    public void setVehicleId(String vehicleId) { this.vehicleId = vehicleId; }
    
    public LocalDateTime getDate() { return date; }
    public void setDate(LocalDateTime date) { this.date = date; }
    
    public BigDecimal getStartOdometer() { return startOdometer; }
    public void setStartOdometer(BigDecimal startOdometer) { this.startOdometer = startOdometer; }
    
    public BigDecimal getEndOdometer() { return endOdometer; }
    public void setEndOdometer(BigDecimal endOdometer) { this.endOdometer = endOdometer; }
    
    public BigDecimal getDistance() { return distance; }
    public void setDistance(BigDecimal distance) { this.distance = distance; }
    
    public String getPurpose() { return purpose; }
    public void setPurpose(String purpose) { this.purpose = purpose; }
    
    public String getRoute() { return route; }
    public void setRoute(String route) { this.route = route; }
    
    public String getDriverId() { return driverId; }
    public void setDriverId(String driverId) { this.driverId = driverId; }
    
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
    
    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}