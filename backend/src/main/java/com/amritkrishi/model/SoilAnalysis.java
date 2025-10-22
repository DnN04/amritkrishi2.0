// package com.amritkrishi.model;

// import jakarta.persistence.*;
// import java.time.LocalDateTime;

// @Entity
// @Table(name = "soil_analysis")
// public class SoilAnalysis {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
    
//     @ManyToOne
//     @JoinColumn(name = "farmer_id", nullable = false)
//     private Farmer farmer;
    
//     @Column(name = "soil_ph")
//     private Double soilPh;
    
//     @Column(name = "organic_carbon")
//     private Double organicCarbon;
    
//     @Column(name = "nitrogen_level")
//     private Integer nitrogenLevel;
    
//     @Column(name = "soil_type")
//     private String soilType;
    
//     @Column(name = "analysis_date")
//     private LocalDateTime analysisDate;
    
//     public SoilAnalysis() {
//         this.analysisDate = LocalDateTime.now();
//     }
    
//     public SoilAnalysis(Farmer farmer, Double soilPh, Double organicCarbon, Integer nitrogenLevel, String soilType) {
//         this();
//         this.farmer = farmer;
//         this.soilPh = soilPh;
//         this.organicCarbon = organicCarbon;
//         this.nitrogenLevel = nitrogenLevel;
//         this.soilType = soilType;
//     }
    
//     // Getters and Setters
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }
    
//     public Farmer getFarmer() { return farmer; }
//     public void setFarmer(Farmer farmer) { this.farmer = farmer; }
    
//     public Double getSoilPh() { return soilPh; }
//     public void setSoilPh(Double soilPh) { this.soilPh = soilPh; }
    
//     public Double getOrganicCarbon() { return organicCarbon; }
//     public void setOrganicCarbon(Double organicCarbon) { this.organicCarbon = organicCarbon; }
    
//     public Integer getNitrogenLevel() { return nitrogenLevel; }
//     public void setNitrogenLevel(Integer nitrogenLevel) { this.nitrogenLevel = nitrogenLevel; }
    
//     public String getSoilType() { return soilType; }
//     public void setSoilType(String soilType) { this.soilType = soilType; }
    
//     public LocalDateTime getAnalysisDate() { return analysisDate; }
//     public void setAnalysisDate(LocalDateTime analysisDate) { this.analysisDate = analysisDate; }
// }

package com.amritkrishi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "soil_analysis")
public class SoilAnalysis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Double soilPh;
    private Double organicCarbon;
    private Integer nitrogenLevel;
    private String soilType;
    
    // Add these fields
    private Double latitude;
    private Double longitude;
    
    @ManyToOne
    @JoinColumn(name = "farmer_id")
    private Farmer farmer;
    
    // Constructors
    public SoilAnalysis() {}
    
    public SoilAnalysis(Long id, Double soilPh, Double organicCarbon, Integer nitrogenLevel, String soilType) {
        this.id = id;
        this.soilPh = soilPh;
        this.organicCarbon = organicCarbon;
        this.nitrogenLevel = nitrogenLevel;
        this.soilType = soilType;
    }
    
    public SoilAnalysis(Long id, Double soilPh, Double organicCarbon, Integer nitrogenLevel, String soilType, Double latitude, Double longitude) {
        this.id = id;
        this.soilPh = soilPh;
        this.organicCarbon = organicCarbon;
        this.nitrogenLevel = nitrogenLevel;
        this.soilType = soilType;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Double getSoilPh() { return soilPh; }
    public void setSoilPh(Double soilPh) { this.soilPh = soilPh; }
    
    public Double getOrganicCarbon() { return organicCarbon; }
    public void setOrganicCarbon(Double organicCarbon) { this.organicCarbon = organicCarbon; }
    
    public Integer getNitrogenLevel() { return nitrogenLevel; }
    public void setNitrogenLevel(Integer nitrogenLevel) { this.nitrogenLevel = nitrogenLevel; }
    
    public String getSoilType() { return soilType; }
    public void setSoilType(String soilType) { this.soilType = soilType; }
    
    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }
    
    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }
    
    public Farmer getFarmer() { return farmer; }
    public void setFarmer(Farmer farmer) { this.farmer = farmer; }
}