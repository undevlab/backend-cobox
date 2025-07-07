package com.cobox.fleet.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "fuel_records_summaries")
public class FuelRecordSummary {
    
    @Id
    private String id;
    
    @Column(name = "service_id", nullable = false)
    private String serviceId;
    
    @Column(name = "total_records", nullable = false)
    private Integer totalRecords;
    
   @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
    @Column(name = "initial_date", nullable = false)
    private LocalDateTime initialDate;
    
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
    @Column(name = "final_date", nullable = false)
    private LocalDateTime finalDate;
    
    @Column(name = "total_fuel", precision = 8, scale = 2)
    private BigDecimal totalFuel;
    
    @Column(nullable = false)
    private String plates;
    
    // Constructors
    public FuelRecordSummary() {}
    
    public FuelRecordSummary(String id, String serviceId, Integer totalRecords, LocalDateTime initialDate,
                           LocalDateTime finalDate, BigDecimal totalFuel, String plates) {
        this.id = id;
        this.serviceId = serviceId;
        this.totalRecords = totalRecords;
        this.initialDate = initialDate;
        this.finalDate = finalDate;
        this.totalFuel = totalFuel;
        this.plates = plates;
    }
    
    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getServiceId() { return serviceId; }
    public void setServiceId(String serviceId) { this.serviceId = serviceId; }
    
    public Integer getTotalRecords() { return totalRecords; }
    public void setTotalRecords(Integer totalRecords) { this.totalRecords = totalRecords; }
    
    public LocalDateTime getInitialDate() { return initialDate; }
    public void setInitialDate(LocalDateTime initialDate) { this.initialDate = initialDate; }
    
    public LocalDateTime getFinalDate() { return finalDate; }
    public void setFinalDate(LocalDateTime finalDate) { this.finalDate = finalDate; }
    
    public BigDecimal getTotalFuel() { return totalFuel; }
    public void setTotalFuel(BigDecimal totalFuel) { this.totalFuel = totalFuel; }
    
    public String getPlates() { return plates; }
    public void setPlates(String plates) { this.plates = plates; }
}