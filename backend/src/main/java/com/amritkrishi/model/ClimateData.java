// package com.amritkrishi.model;

// import jakarta.persistence.*;
// import java.time.LocalDateTime;

// @Entity
// @Table(name = "climate_data")
// public class ClimateData {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
    
//     @ManyToOne
//     @JoinColumn(name = "farmer_id", nullable = false)
//     private Farmer farmer;
    
//     @Column(name = "avg_temperature")
//     private Double avgTemperature;
    
//     @Column(name = "annual_rainfall")
//     private Integer annualRainfall;
    
//     @Column(name = "sunshine_hours")
//     private Double sunshineHours;
    
//     @Column(name = "climate_zone")
//     private String climateZone;
    
//     @Column(name = "recorded_date")
//     private LocalDateTime recordedDate;
    
//     public ClimateData() {
//         this.recordedDate = LocalDateTime.now();
//     }
    
//     public ClimateData(Farmer farmer, Double avgTemperature, Integer annualRainfall, Double sunshineHours, String climateZone) {
//         this();
//         this.farmer = farmer;
//         this.avgTemperature = avgTemperature;
//         this.annualRainfall = annualRainfall;
//         this.sunshineHours = sunshineHours;
//         this.climateZone = climateZone;
//     }
    
//     // Getters and Setters
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }
    
//     public Farmer getFarmer() { return farmer; }
//     public void setFarmer(Farmer farmer) { this.farmer = farmer; }
    
//     public Double getAvgTemperature() { return avgTemperature; }
//     public void setAvgTemperature(Double avgTemperature) { this.avgTemperature = avgTemperature; }
    
//     public Integer getAnnualRainfall() { return annualRainfall; }
//     public void setAnnualRainfall(Integer annualRainfall) { this.annualRainfall = annualRainfall; }
    
//     public Double getSunshineHours() { return sunshineHours; }
//     public void setSunshineHours(Double sunshineHours) { this.sunshineHours = sunshineHours; }
    
//     public String getClimateZone() { return climateZone; }
//     public void setClimateZone(String climateZone) { this.climateZone = climateZone; }
    
//     public LocalDateTime getRecordedDate() { return recordedDate; }
//     public void setRecordedDate(LocalDateTime recordedDate) { this.recordedDate = recordedDate; }
// }

package com.amritkrishi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "climate_data")
public class ClimateData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Double avgTemperature;
    private Integer annualRainfall;
    private Double sunshineHours;
    private String climateZone;
    
    // Add these fields for chart data
    @Transient // This won't be stored in database
    private double[] monthlyTemp;
    
    @Transient
    private double[] monthlyRain;
    
    @ManyToOne
    @JoinColumn(name = "farmer_id")
    private Farmer farmer;
    
    // Constructors
    public ClimateData() {}
    
    public ClimateData(Long id, Double avgTemperature, Integer annualRainfall, Double sunshineHours, String climateZone) {
        this.id = id;
        this.avgTemperature = avgTemperature;
        this.annualRainfall = annualRainfall;
        this.sunshineHours = sunshineHours;
        this.climateZone = climateZone;
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Double getAvgTemperature() { return avgTemperature; }
    public void setAvgTemperature(Double avgTemperature) { this.avgTemperature = avgTemperature; }
    
    public Integer getAnnualRainfall() { return annualRainfall; }
    public void setAnnualRainfall(Integer annualRainfall) { this.annualRainfall = annualRainfall; }
    
    public Double getSunshineHours() { return sunshineHours; }
    public void setSunshineHours(Double sunshineHours) { this.sunshineHours = sunshineHours; }
    
    public String getClimateZone() { return climateZone; }
    public void setClimateZone(String climateZone) { this.climateZone = climateZone; }
    
    public double[] getMonthlyTemp() { return monthlyTemp; }
    public void setMonthlyTemp(double[] monthlyTemp) { this.monthlyTemp = monthlyTemp; }
    
    public double[] getMonthlyRain() { return monthlyRain; }
    public void setMonthlyRain(double[] monthlyRain) { this.monthlyRain = monthlyRain; }
    
    public Farmer getFarmer() { return farmer; }
    public void setFarmer(Farmer farmer) { this.farmer = farmer; }
}