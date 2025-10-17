package com.amritkrishi.service;


import com.amritkrishi.model.Farmer;
import com.amritkrishi.model.SoilAnalysis;
import com.amritkrishi.model.ClimateData;
import com.amritkrishi.model.CropRecommendation;
import com.amritkrishi.repository.FarmerRepository;
import com.amritkrishi.repository.SoilAnalysisRepository;
import com.amritkrishi.repository.ClimateDataRepository;
import com.amritkrishi.repository.CropRecommendationRepository;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AnalysisService {

    @Autowired
    private FarmerRepository farmerRepository;

    @Autowired
    private CropRecommendationRepository cropRecommendationRepository;

    @Autowired
    private SoilAnalysisRepository soilAnalysisRepository;

    @Autowired
    private ClimateDataRepository climateDataRepository;

    public Map<String, Object> analyzeAndRecommend(String farmerName, Double latitude, Double longitude, String locationMethod) {
        // Step 1: Save farmer
        Farmer farmer = new Farmer(farmerName, latitude, longitude, locationMethod, "Detected location", "en");
        Farmer savedFarmer = farmerRepository.save(farmer);

        // Step 2: Generate REALISTIC soil data based on location
        SoilAnalysis soilAnalysis = generateRealisticSoilData(latitude, longitude);
        soilAnalysis.setFarmer(savedFarmer);
        soilAnalysisRepository.save(soilAnalysis);

        // Step 3: Generate REALISTIC climate data based on location
        ClimateData climateData = generateRealisticClimateData(latitude, longitude);
        climateData.setFarmer(savedFarmer);
        climateDataRepository.save(climateData);

        // Step 4: Generate REALISTIC crop recommendations
        Map<String, Object> recommendations = generateRealisticCropRecommendations(savedFarmer, soilAnalysis, climateData);

        return recommendations;
    }

    // REALISTIC SOIL DATA based on Indian soil patterns
    private SoilAnalysis generateRealisticSoilData(Double lat, Double lon) {
        String region = getIndianRegion(lat, lon);
        double soilPH = 6.5;
        double organicCarbon = 1.2;
        int nitrogenLevel = 1200;
        String soilType = "Loam";

        // Real Indian soil patterns based on agricultural research
        switch(region) {
            case "Northern Plains":
                soilPH = 7.2 + (Math.random() * 0.6 - 0.3); // Alkaline alluvial soil
                organicCarbon = 1.8 + (Math.random() * 0.4);
                nitrogenLevel = 1500 + (int)(Math.random() * 500);
                soilType = "Alluvial";
                break;
            case "Western Dry":
                soilPH = 8.0 + (Math.random() * 0.5 - 0.2); // Alkaline desert soil
                organicCarbon = 0.8 + (Math.random() * 0.3);
                nitrogenLevel = 800 + (int)(Math.random() * 300);
                soilType = "Desert";
                break;
            case "Eastern Plateau":
                soilPH = 6.0 + (Math.random() * 0.8 - 0.4); // Slightly acidic
                organicCarbon = 1.5 + (Math.random() * 0.5);
                nitrogenLevel = 1300 + (int)(Math.random() * 400);
                soilType = "Red Soil";
                break;
            case "Southern Plateau":
                soilPH = 6.8 + (Math.random() * 0.6 - 0.3); // Neutral to slightly acidic
                organicCarbon = 1.2 + (Math.random() * 0.4);
                nitrogenLevel = 1100 + (int)(Math.random() * 300);
                soilType = "Black Cotton";
                break;
            case "Coastal":
                soilPH = 7.5 + (Math.random() * 0.5 - 0.2); // Saline coastal
                organicCarbon = 1.0 + (Math.random() * 0.3);
                nitrogenLevel = 1000 + (int)(Math.random() * 300);
                soilType = "Coastal Alluvial";
                break;
            case "Himalayan":
                soilPH = 6.2 + (Math.random() * 0.8 - 0.4); // Mountain soil
                organicCarbon = 2.0 + (Math.random() * 0.6);
                nitrogenLevel = 1400 + (int)(Math.random() * 400);
                soilType = "Mountain";
                break;
        }

        return new SoilAnalysis(null, soilPH, organicCarbon, nitrogenLevel, soilType);
    }

    // REALISTIC CLIMATE DATA based on Indian climate zones
    private ClimateData generateRealisticClimateData(Double lat, Double lon) {
        String region = getIndianRegion(lat, lon);
        double temperature = 25.0;
        int rainfall = 1000;
        double sunshine = 6.0;
        String climateZone = "Tropical";

        // Real Indian climate patterns
        switch(region) {
            case "Northern Plains":
                temperature = 22.0 + (Math.random() * 8.0 - 4.0); // 18-26°C
                rainfall = 800 + (int)(Math.random() * 600); // 800-1400mm
                sunshine = 7.0 + (Math.random() * 2.0);
                climateZone = "Subtropical";
                break;
            case "Western Dry":
                temperature = 28.0 + (Math.random() * 6.0 - 3.0); // 25-31°C
                rainfall = 300 + (int)(Math.random() * 300); // 300-600mm
                sunshine = 8.0 + (Math.random() * 2.0);
                climateZone = "Arid";
                break;
            case "Eastern Plateau":
                temperature = 26.0 + (Math.random() * 6.0 - 3.0); // 23-29°C
                rainfall = 1200 + (int)(Math.random() * 800); // 1200-2000mm
                sunshine = 6.5 + (Math.random() * 1.5);
                climateZone = "Humid Subtropical";
                break;
            case "Southern Plateau":
                temperature = 28.0 + (Math.random() * 4.0 - 2.0); // 26-30°C
                rainfall = 900 + (int)(Math.random() * 600); // 900-1500mm
                sunshine = 6.0 + (Math.random() * 2.0);
                climateZone = "Tropical Savanna";
                break;
            case "Coastal":
                temperature = 30.0 + (Math.random() * 4.0 - 2.0); // 28-32°C
                rainfall = 2000 + (int)(Math.random() * 1500); // 2000-3500mm
                sunshine = 5.5 + (Math.random() * 1.5);
                climateZone = "Tropical Coastal";
                break;
            case "Himalayan":
                temperature = 18.0 + (Math.random() * 6.0 - 3.0); // 15-21°C
                rainfall = 1500 + (int)(Math.random() * 1000); // 1500-2500mm
                sunshine = 6.5 + (Math.random() * 1.5);
                climateZone = "Mountain";
                break;
        }

        return new ClimateData(null, temperature, rainfall, sunshine, climateZone);
    }

    // REALISTIC CROP RECOMMENDATIONS based on ICAR data
    // private Map<String, Object> generateRealisticCropRecommendations(Farmer farmer, SoilAnalysis soil, ClimateData climate) {
    //     Map<String, Object> result = new HashMap<>();
        
    //     String region = getIndianRegion(farmer.getLatitude(), farmer.getLongitude());
    //     List<CropData> suitableCrops = getRegionSpecificCrops(region, soil, climate);
        
    //     for (CropData cropData : suitableCrops) {
    //         CropRecommendation recommendation = new CropRecommendation(
    //             farmer, 
    //             cropData.name,
    //             cropData.score,
    //             cropData.season,
    //             soil.getSoilPh(),
    //             climate.getAvgTemperature(),
    //             climate.getAnnualRainfall(),
    //             cropData.duration,
    //             cropData.yield,
    //             cropData.water
    //         );
            
    //         cropRecommendationRepository.save(recommendation);
    //     }
        
    //     result.put("farmerId", farmer.getId());
    //     result.put("soilAnalysis", soil);
    //     result.put("climateData", climate);
    //     result.put("region", region);
    //     result.put("message", "Realistic agricultural analysis completed");
        
    //     return result;
    // }
    // FIXED: Now returns crop recommendations in response
private Map<String, Object> generateRealisticCropRecommendations(Farmer farmer, SoilAnalysis soil, ClimateData climate) {
    Map<String, Object> result = new HashMap<>();
    
    String region = getIndianRegion(farmer.getLatitude(), farmer.getLongitude());
    List<CropData> suitableCrops = getRegionSpecificCrops(region, soil, climate);
    
    List<Map<String, Object>> cropRecommendations = new ArrayList<>();
    
    for (CropData cropData : suitableCrops) {
        // Save to database
        CropRecommendation recommendation = new CropRecommendation(
            farmer, 
            cropData.name,
            cropData.score,
            cropData.season,
            soil.getSoilPh(),
            climate.getAvgTemperature(),
            climate.getAnnualRainfall(),
            cropData.duration,
            cropData.yield,
            cropData.water
        );
        cropRecommendationRepository.save(recommendation);
        
        // ALSO add to response for frontend
        Map<String, Object> cropResponse = new HashMap<>();
        cropResponse.put("cropName", cropData.name);
        cropResponse.put("score", cropData.score);
        cropResponse.put("season", cropData.season);
        cropResponse.put("duration", cropData.duration);
        cropResponse.put("yield", cropData.yield);
        cropResponse.put("waterRequirement", cropData.water);
        cropRecommendations.add(cropResponse);
    }
    
    result.put("farmerId", farmer.getId());
    result.put("soilAnalysis", soil);
    result.put("climateData", climate);
    result.put("region", region);
    result.put("recommendations", cropRecommendations); // ← THIS WAS MISSING!
    result.put("message", "Realistic agricultural analysis completed");
    
    return result;
}
    // Get Indian agricultural regions
    private String getIndianRegion(Double lat, Double lon) {
        if (lat > 30.0) return "Himalayan";
        if (lat > 28.0 && lon < 75.0) return "Western Dry";
        if (lat > 25.0 && lon > 85.0) return "Eastern Plateau";
        if (lat > 20.0 && lat <= 25.0) return "Northern Plains";
        if (lat > 15.0 && lat <= 20.0) return "Southern Plateau";
        if (lat <= 15.0) return "Coastal";
        return "Central Plains";
    }

    // Region-specific crops based on ICAR recommendations
    private List<CropData> getRegionSpecificCrops(String region, SoilAnalysis soil, ClimateData climate) {
        List<CropData> crops = new ArrayList<>();
        
        switch(region) {
            case "Northern Plains":
                crops.add(new CropData("Wheat", calculateScore("Wheat", soil, climate), "Rabi", 120, "4-5 tons/ha", "Medium"));
                crops.add(new CropData("Rice", calculateScore("Rice", soil, climate), "Kharif", 90, "4-6 tons/ha", "High"));
                crops.add(new CropData("Sugarcane", calculateScore("Sugarcane", soil, climate), "Annual", 365, "70-80 tons/ha", "High"));
                crops.add(new CropData("Maize", calculateScore("Maize", soil, climate), "Kharif", 85, "3-4 tons/ha", "Medium"));
                crops.add(new CropData("Mustard", calculateScore("Mustard", soil, climate), "Rabi", 110, "1-2 tons/ha", "Low"));
                break;
                
            case "Western Dry":
                crops.add(new CropData("Pearl Millet", calculateScore("Pearl Millet", soil, climate), "Kharif", 85, "1-2 tons/ha", "Low"));
                crops.add(new CropData("Cluster Bean", calculateScore("Cluster Bean", soil, climate), "Kharif", 90, "0.5-1 ton/ha", "Very Low"));
                crops.add(new CropData("Moong Bean", calculateScore("Moong Bean", soil, climate), "Kharif", 65, "0.5-1 ton/ha", "Low"));
                crops.add(new CropData("Guar", calculateScore("Guar", soil, climate), "Kharif", 95, "1-2 tons/ha", "Very Low"));
                crops.add(new CropData("Isabgol", calculateScore("Isabgol", soil, climate), "Rabi", 110, "1-1.5 tons/ha", "Low"));
                break;
                
            case "Eastern Plateau":
                crops.add(new CropData("Rice", calculateScore("Rice", soil, climate), "Kharif", 90, "3-5 tons/ha", "High"));
                crops.add(new CropData("Pulses", calculateScore("Pulses", soil, climate), "Rabi", 100, "1-2 tons/ha", "Low"));
                crops.add(new CropData("Oilseeds", calculateScore("Oilseeds", soil, climate), "Rabi", 110, "1-2 tons/ha", "Low"));
                crops.add(new CropData("Maize", calculateScore("Maize", soil, climate), "Kharif", 85, "2-3 tons/ha", "Medium"));
                crops.add(new CropData("Vegetables", calculateScore("Vegetables", soil, climate), "Year-round", 60, "15-20 tons/ha", "High"));
                break;
                
            case "Southern Plateau":
                crops.add(new CropData("Cotton", calculateScore("Cotton", soil, climate), "Kharif", 150, "2-3 tons/ha", "Medium"));
                crops.add(new CropData("Groundnut", calculateScore("Groundnut", soil, climate), "Kharif", 105, "1-2 tons/ha", "Low"));
                crops.add(new CropData("Sunflower", calculateScore("Sunflower", soil, climate), "Rabi", 95, "1-2 tons/ha", "Low"));
                crops.add(new CropData("Sugarcane", calculateScore("Sugarcane", soil, climate), "Annual", 365, "80-100 tons/ha", "High"));
                crops.add(new CropData("Sorghum", calculateScore("Sorghum", soil, climate), "Kharif", 90, "2-3 tons/ha", "Low"));
                break;
                
            case "Coastal":
                crops.add(new CropData("Coconut", calculateScore("Coconut", soil, climate), "Annual", 365, "80-100 nuts/tree", "Medium"));
                crops.add(new CropData("Rice", calculateScore("Rice", soil, climate), "Kharif", 90, "5-7 tons/ha", "High"));
                crops.add(new CropData("Banana", calculateScore("Banana", soil, climate), "Annual", 365, "40-50 tons/ha", "High"));
                crops.add(new CropData("Black Pepper", calculateScore("Black Pepper", soil, climate), "Annual", 365, "500-800 kg/ha", "Medium"));
                crops.add(new CropData("Cashew", calculateScore("Cashew", soil, climate), "Annual", 365, "1-2 tons/ha", "Low"));
                break;
                
            case "Himalayan":
                crops.add(new CropData("Apple", calculateScore("Apple", soil, climate), "Annual", 365, "15-20 tons/ha", "Medium"));
                crops.add(new CropData("Potato", calculateScore("Potato", soil, climate), "Rabi", 100, "20-25 tons/ha", "High"));
                crops.add(new CropData("Maize", calculateScore("Maize", soil, climate), "Kharif", 85, "2-3 tons/ha", "Medium"));
                crops.add(new CropData("Saffron", calculateScore("Saffron", soil, climate), "Annual", 365, "2-3 kg/ha", "Low"));
                crops.add(new CropData("Raju", calculateScore("Raju", soil, climate), "Kharif", 75, "1-2 tons/ha", "Low"));
                break;
                
            default: // Central Plains
                crops.add(new CropData("Wheat", calculateScore("Wheat", soil, climate), "Rabi", 120, "3-4 tons/ha", "Medium"));
                crops.add(new CropData("Rice", calculateScore("Rice", soil, climate), "Kharif", 90, "4-5 tons/ha", "High"));
                crops.add(new CropData("Soybean", calculateScore("Soybean", soil, climate), "Kharif", 95, "2-3 tons/ha", "Medium"));
                crops.add(new CropData("Gram", calculateScore("Gram", soil, climate), "Rabi", 100, "1-2 tons/ha", "Low"));
                crops.add(new CropData("Maize", calculateScore("Maize", soil, climate), "Kharif", 85, "3-4 tons/ha", "Medium"));
        }
        
        // Sort by score and take top 5
        crops.sort((a, b) -> Integer.compare(b.score, a.score));
        return crops.subList(0, Math.min(5, crops.size()));
    }

    // Realistic crop scoring based on agricultural science
    private int calculateScore(String cropName, SoilAnalysis soil, ClimateData climate) {
        int score = 100;
        double soilPH = soil.getSoilPh();
        double temperature = climate.getAvgTemperature();
        int rainfall = climate.getAnnualRainfall();
        double organicCarbon = soil.getOrganicCarbon();

        // Crop-specific requirements based on agricultural research
        switch (cropName) {
            case "Rice":
                if (soilPH < 5.5 || soilPH > 7.0) score -= 30;
                if (temperature < 20 || temperature > 35) score -= 25;
                if (rainfall < 1000) score -= 20;
                if (organicCarbon < 1.0) score -= 15;
                break;
            case "Wheat":
                if (soilPH < 6.0 || soilPH > 7.5) score -= 30;
                if (temperature < 10 || temperature > 25) score -= 25;
                if (rainfall < 500) score -= 20;
                if (organicCarbon < 1.2) score -= 10;
                break;
            case "Sugarcane":
                if (soilPH < 6.5 || soilPH > 7.5) score -= 25;
                if (temperature < 20 || temperature > 35) score -= 20;
                if (rainfall < 1500) score -= 30;
                if (organicCarbon < 1.5) score -= 15;
                break;
            case "Cotton":
                if (soilPH < 6.0 || soilPH > 8.0) score -= 20;
                if (temperature < 21 || temperature > 35) score -= 25;
                if (rainfall < 500) score -= 15;
                if (organicCarbon < 1.0) score -= 10;
                break;
            case "Pearl Millet":
                if (soilPH < 6.5 || soilPH > 8.5) score -= 15;
                if (temperature < 25 || temperature > 35) score -= 20;
                if (rainfall > 800) score -= 25; // Doesn't like too much rain
                if (organicCarbon < 0.8) score -= 10;
                break;
            case "Apple":
                if (soilPH < 5.5 || soilPH > 6.5) score -= 30;
                if (temperature < 15 || temperature > 25) score -= 35;
                if (rainfall < 1000) score -= 20;
                if (organicCarbon < 2.0) score -= 20;
                break;
            case "Coconut":
                if (soilPH < 5.0 || soilPH > 8.0) score -= 20;
                if (temperature < 20 || temperature > 35) score -= 25;
                if (rainfall < 1500) score -= 30;
                if (organicCarbon < 1.0) score -= 10;
                break;
            default:
                // Generic scoring for other crops
                if (soilPH < 6.0 || soilPH > 7.5) score -= 20;
                if (temperature < 15 || temperature > 32) score -= 20;
                if (rainfall < 500) score -= 15;
                if (organicCarbon < 1.0) score -= 10;
        }
        
        // Add small randomness for natural variation
        score += (int)(Math.random() * 10) - 5;
        
        return Math.max(40, Math.min(100, score)); // Keep between 40-100
    }

    // Helper class for crop data
    class CropData {
        String name;
        int score;
        String season;
        int duration;
        String yield;
        String water;
        
        CropData(String name, int score, String season, int duration, String yield, String water) {
            this.name = name;
            this.score = score;
            this.season = season;
            this.duration = duration;
            this.yield = yield;
            this.water = water;
        }
    }
}