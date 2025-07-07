package com.cobox.fleet.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "services")
public class Service {
    
    @Id
    private String id;
    
    @Column(nullable = false)
    private String date;
    
    @Column(nullable = false, length = 1000)
    private String route;
    
    @Column(nullable = false)
    private String driver;
    
    @Column(nullable = false)
    private String plate;
    
    @Column(name = "departure_time", nullable = false)
    private String departureTime;
    
    @Column(nullable = false)
    private String status = "PENDING";
    
    // Constructors
    public Service() {}
    
    public Service(String id, String date, String route, String driver, String plate, 
                  String departureTime, String status) {
        this.id = id;
        this.date = date;
        this.route = route;
        this.driver = driver;
        this.plate = plate;
        this.departureTime = departureTime;
        this.status = status;
    }
    
    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    
    public String getRoute() { return route; }
    public void setRoute(String route) { this.route = route; }
    
    public String getDriver() { return driver; }
    public void setDriver(String driver) { this.driver = driver; }
    
    public String getPlate() { return plate; }
    public void setPlate(String plate) { this.plate = plate; }
    
    public String getDepartureTime() { return departureTime; }
    public void setDepartureTime(String departureTime) { this.departureTime = departureTime; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}