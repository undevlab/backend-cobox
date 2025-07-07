package com.cobox.fleet.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "vehicles")
public class Vehicle {
    
    @Id
    private String id;
    
    @Column(nullable = false)
    private String plate;
    
    @Column(nullable = false)
    private String brand;
    
    @Column(nullable = false)
    private String model;
    
    @Column(nullable = false)
    private Integer year;
    
    @Column(nullable = false)
    private String type;
    
    @Column(name = "load_capacity")
    private Integer loadCapacity;
    
    @Column(name = "tank_capacity")
    private Integer tankCapacity;
    
    @Column(nullable = false)
    private String status = "AVAILABLE";
    
    @Column(name = "current_mileage", precision = 10, scale = 2)
    private BigDecimal currentMileage;
    
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
    @Column(name = "last_maintenance")
    private LocalDateTime lastMaintenance;
    
    @Column(nullable = false)
    private Boolean active = true;
    
    // Constructors
    public Vehicle() {}
    
    public Vehicle(String id, String plate, String brand, String model, Integer year, String type, 
                  Integer loadCapacity, Integer tankCapacity, String status, BigDecimal currentMileage, 
                  LocalDateTime lastMaintenance, Boolean active) {
        this.id = id;
        this.plate = plate;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.type = type;
        this.loadCapacity = loadCapacity;
        this.tankCapacity = tankCapacity;
        this.status = status;
        this.currentMileage = currentMileage;
        this.lastMaintenance = lastMaintenance;
        this.active = active;
    }
    
    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getPlate() { return plate; }
    public void setPlate(String plate) { this.plate = plate; }
    
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    
    public Integer getYear() { return year; }
    public void setYear(Integer year) { this.year = year; }
    
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    
    public Integer getLoadCapacity() { return loadCapacity; }
    public void setLoadCapacity(Integer loadCapacity) { this.loadCapacity = loadCapacity; }
    
    public Integer getTankCapacity() { return tankCapacity; }
    public void setTankCapacity(Integer tankCapacity) { this.tankCapacity = tankCapacity; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public BigDecimal getCurrentMileage() { return currentMileage; }
    public void setCurrentMileage(BigDecimal currentMileage) { this.currentMileage = currentMileage; }
    
    public LocalDateTime getLastMaintenance() { return lastMaintenance; }
    public void setLastMaintenance(LocalDateTime lastMaintenance) { this.lastMaintenance = lastMaintenance; }
    
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}