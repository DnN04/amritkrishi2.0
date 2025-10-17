package com.amritkrishi.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "crop_recommendations")
public class CropRecommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "farmer_id", nullable = false)
    private Farmer farmer;
    
    @Column(name = "crop_name", nullable = false)
    private String cropName;
    
    @Column(name = "crop_type")
    private String cropType;
    
    @Column(name = "suitability_score")
    private Integer suitabilityScore;
    
    private String season;
    
    @Column(name = "soil_ph")
    private Double soilPh;
    
    private Double temperature;
    
    private Integer rainfall;
    
    @Column(name = "duration_days")
    private Integer durationDays;
    
    @Column(name = "expected_yield")
    private String expectedYield;
    
    @Column(name = "water_requirement")
    private String waterRequirement;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    // Constructors
    public CropRecommendation() {
        this.createdAt = LocalDateTime.now();
    }
    
    public CropRecommendation(Farmer farmer, String cropName, Integer suitabilityScore, 
                             String season, Double soilPh, Double temperature, 
                             Integer rainfall, Integer durationDays, String expectedYield, 
                             String waterRequirement) {
        this();
        this.farmer = farmer;
        this.cropName = cropName;
        this.suitabilityScore = suitabilityScore;
        this.season = season;
        this.soilPh = soilPh;
        this.temperature = temperature;
        this.rainfall = rainfall;
        this.durationDays = durationDays;
        this.expectedYield = expectedYield;
        this.waterRequirement = waterRequirement;
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Farmer getFarmer() { return farmer; }
    public void setFarmer(Farmer farmer) { this.farmer = farmer; }
    
    public String getCropName() { return cropName; }
    public void setCropName(String cropName) { this.cropName = cropName; }
    
    public String getCropType() { return cropType; }
    public void setCropType(String cropType) { this.cropType = cropType; }
    
    public Integer getSuitabilityScore() { return suitabilityScore; }
    public void setSuitabilityScore(Integer suitabilityScore) { this.suitabilityScore = suitabilityScore; }
    
    public String getSeason() { return season; }
    public void setSeason(String season) { this.season = season; }
    
    public Double getSoilPh() { return soilPh; }
    public void setSoilPh(Double soilPh) { this.soilPh = soilPh; }
    
    public Double getTemperature() { return temperature; }
    public void setTemperature(Double temperature) { this.temperature = temperature; }
    
    public Integer getRainfall() { return rainfall; }
    public void setRainfall(Integer rainfall) { this.rainfall = rainfall; }
    
    public Integer getDurationDays() { return durationDays; }
    public void setDurationDays(Integer durationDays) { this.durationDays = durationDays; }
    
    public String getExpectedYield() { return expectedYield; }
    public void setExpectedYield(String expectedYield) { this.expectedYield = expectedYield; }
    
    public String getWaterRequirement() { return waterRequirement; }
    public void setWaterRequirement(String waterRequirement) { this.waterRequirement = waterRequirement; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}