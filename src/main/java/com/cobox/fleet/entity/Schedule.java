package com.cobox.fleet.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "schedules")
public class Schedule {
    
    @Id
    private String id;
    
    @Column(name = "schedule_date", nullable = false)
    private String scheduleDate;
    
    @Column(name = "service_date", nullable = false)
    private String serviceDate;
    
    @Column(nullable = false)
    private String origin;
    
    @Column(nullable = false, length = 1000)
    private String destination;
    
    @Column(nullable = false)
    private String driver;
    
    @Column(nullable = false)
    private String plate;
    
    @Column(name = "departure_time", nullable = false)
    private String departureTime;
    
    @Column(name = "final_cost", precision = 10, scale = 2)
    private BigDecimal finalCost;
    
    // Constructors
    public Schedule() {}
    
    public Schedule(String id, String scheduleDate, String serviceDate, String origin, String destination,
                   String driver, String plate, String departureTime, BigDecimal finalCost) {
        this.id = id;
        this.scheduleDate = scheduleDate;
        this.serviceDate = serviceDate;
        this.origin = origin;
        this.destination = destination;
        this.driver = driver;
        this.plate = plate;
        this.departureTime = departureTime;
        this.finalCost = finalCost;
    }
    
    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getScheduleDate() { return scheduleDate; }
    public void setScheduleDate(String scheduleDate) { this.scheduleDate = scheduleDate; }
    
    public String getServiceDate() { return serviceDate; }
    public void setServiceDate(String serviceDate) { this.serviceDate = serviceDate; }
    
    public String getOrigin() { return origin; }
    public void setOrigin(String origin) { this.origin = origin; }
    
    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }
    
    public String getDriver() { return driver; }
    public void setDriver(String driver) { this.driver = driver; }
    
    public String getPlate() { return plate; }
    public void setPlate(String plate) { this.plate = plate; }
    
    public String getDepartureTime() { return departureTime; }
    public void setDepartureTime(String departureTime) { this.departureTime = departureTime; }
    
    public BigDecimal getFinalCost() { return finalCost; }
    public void setFinalCost(BigDecimal finalCost) { this.finalCost = finalCost; }
}
