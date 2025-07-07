package com.cobox.fleet.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "fuel_records")
public class FuelRecord {
    
    @Id
    private String id;
    
    @Column(name = "vehicle_id", nullable = false)
    private Long vehicleId;
    
    @Column(name = "vehicle_plate", nullable = false)
    private String vehiclePlate;
    
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
    @Column(nullable = false)
    private LocalDateTime date;
    
    @Column(name = "fuel_type", nullable = false)
    private String fuelType;
    
    @Column(precision = 8, scale = 2, nullable = false)
    private BigDecimal quantity;
    
    @Column(name = "total_cost", precision = 10, scale = 2, nullable = false)  
    private BigDecimal totalCost;
    
    @Column(name = "current_mileage", precision = 10, scale = 2)
    private BigDecimal currentMileage;
    
    @Column(nullable = false)
    private String station;
    
    @Column(nullable = false)
    private String location;
    
    @Column(name = "invoice_number")
    private String invoiceNumber;
    
    @Column(length = 500)
    private String notes;
    
    // Constructors
    public FuelRecord() {}
    
    public FuelRecord(String id, Long vehicleId, String vehiclePlate, LocalDateTime date, String fuelType,
                     BigDecimal quantity, BigDecimal totalCost, BigDecimal currentMileage, String station,
                     String location, String invoiceNumber, String notes) {
        this.id = id;
        this.vehicleId = vehicleId;
        this.vehiclePlate = vehiclePlate;
        this.date = date;
        this.fuelType = fuelType;
        this.quantity = quantity;
        this.totalCost = totalCost;
        this.currentMileage = currentMileage;
        this.station = station;
        this.location = location;
        this.invoiceNumber = invoiceNumber;
        this.notes = notes;
    }
    
    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public Long getVehicleId() { return vehicleId; }
    public void setVehicleId(Long vehicleId) { this.vehicleId = vehicleId; }
    
    public String getVehiclePlate() { return vehiclePlate; }
    public void setVehiclePlate(String vehiclePlate) { this.vehiclePlate = vehiclePlate; }
    
    public LocalDateTime getDate() { return date; }
    public void setDate(LocalDateTime date) { this.date = date; }
    
    public String getFuelType() { return fuelType; }
    public void setFuelType(String fuelType) { this.fuelType = fuelType; }
    
    public BigDecimal getQuantity() { return quantity; }
    public void setQuantity(BigDecimal quantity) { this.quantity = quantity; }
    
    public BigDecimal getTotalCost() { return totalCost; }
    public void setTotalCost(BigDecimal totalCost) { this.totalCost = totalCost; }
    
    public BigDecimal getCurrentMileage() { return currentMileage; }
    public void setCurrentMileage(BigDecimal currentMileage) { this.currentMileage = currentMileage; }
    
    public String getStation() { return station; }
    public void setStation(String station) { this.station = station; }
    
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    
    public String getInvoiceNumber() { return invoiceNumber; }
    public void setInvoiceNumber(String invoiceNumber) { this.invoiceNumber = invoiceNumber; }
    
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}