package com.amritkrishi.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "farmers")
public class Farmer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "farmer_name", nullable = false)
    private String farmerName;
    
    @Column(nullable = false)
    private Double latitude;
    
    @Column(nullable = false)
    private Double longitude;
    
    @Column(name = "location_method")
    private String locationMethod;
    
    private String address;
    
    @Column(name = "preferred_language")
    private String preferredLanguage = "en";
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    // Constructors
    public Farmer() {
        this.createdAt = LocalDateTime.now();
    }
    
    public Farmer(String farmerName, Double latitude, Double longitude, 
                  String locationMethod, String address, String preferredLanguage) {
        this();
        this.farmerName = farmerName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.locationMethod = locationMethod;
        this.address = address;
        this.preferredLanguage = preferredLanguage;
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getFarmerName() { return farmerName; }
    public void setFarmerName(String farmerName) { this.farmerName = farmerName; }
    
    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }
    
    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }
    
    public String getLocationMethod() { return locationMethod; }
    public void setLocationMethod(String locationMethod) { this.locationMethod = locationMethod; }
    
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    
    public String getPreferredLanguage() { return preferredLanguage; }
    public void setPreferredLanguage(String preferredLanguage) { this.preferredLanguage = preferredLanguage; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}