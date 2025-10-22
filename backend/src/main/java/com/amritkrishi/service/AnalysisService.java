// package com.amritkrishi.service;


// import com.amritkrishi.model.Farmer;
// import com.amritkrishi.model.SoilAnalysis;
// import com.amritkrishi.model.ClimateData;
// import com.amritkrishi.model.CropRecommendation;
// import com.amritkrishi.repository.FarmerRepository;
// import com.amritkrishi.repository.SoilAnalysisRepository;
// import com.amritkrishi.repository.ClimateDataRepository;
// import com.amritkrishi.repository.CropRecommendationRepository;



// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import java.util.*;

// @Service
// public class AnalysisService {

//     @Autowired
//     private FarmerRepository farmerRepository;

//     @Autowired
//     private CropRecommendationRepository cropRecommendationRepository;

//     @Autowired
//     private SoilAnalysisRepository soilAnalysisRepository;

//     @Autowired
//     private ClimateDataRepository climateDataRepository;

//     public Map<String, Object> analyzeAndRecommend(String farmerName, Double latitude, Double longitude, String locationMethod) {
//         // Step 1: Save farmer
//         Farmer farmer = new Farmer(farmerName, latitude, longitude, locationMethod, "Detected location", "en");
//         Farmer savedFarmer = farmerRepository.save(farmer);

//         // Step 2: Generate REALISTIC soil data based on location
//         SoilAnalysis soilAnalysis = generateRealisticSoilData(latitude, longitude);
//         soilAnalysis.setFarmer(savedFarmer);
//         soilAnalysisRepository.save(soilAnalysis);

//         // Step 3: Generate REALISTIC climate data based on location
//         ClimateData climateData = generateRealisticClimateData(latitude, longitude);
//         climateData.setFarmer(savedFarmer);
//         climateDataRepository.save(climateData);

//         // Step 4: Generate REALISTIC crop recommendations
//         Map<String, Object> recommendations = generateRealisticCropRecommendations(savedFarmer, soilAnalysis, climateData);

//         return recommendations;
//     }

//     // REALISTIC SOIL DATA based on Indian soil patterns
//     private SoilAnalysis generateRealisticSoilData(Double lat, Double lon) {
//         String region = getIndianRegion(lat, lon);
//         double soilPH = 6.5;
//         double organicCarbon = 1.2;
//         int nitrogenLevel = 1200;
//         String soilType = "Loam";

//         // Real Indian soil patterns based on agricultural research
//         switch(region) {
//             case "Northern Plains":
//                 soilPH = 7.2 + (Math.random() * 0.6 - 0.3); // Alkaline alluvial soil
//                 organicCarbon = 1.8 + (Math.random() * 0.4);
//                 nitrogenLevel = 1500 + (int)(Math.random() * 500);
//                 soilType = "Alluvial";
//                 break;
//             case "Western Dry":
//                 soilPH = 8.0 + (Math.random() * 0.5 - 0.2); // Alkaline desert soil
//                 organicCarbon = 0.8 + (Math.random() * 0.3);
//                 nitrogenLevel = 800 + (int)(Math.random() * 300);
//                 soilType = "Desert";
//                 break;
//             case "Eastern Plateau":
//                 soilPH = 6.0 + (Math.random() * 0.8 - 0.4); // Slightly acidic
//                 organicCarbon = 1.5 + (Math.random() * 0.5);
//                 nitrogenLevel = 1300 + (int)(Math.random() * 400);
//                 soilType = "Red Soil";
//                 break;
//             case "Southern Plateau":
//                 soilPH = 6.8 + (Math.random() * 0.6 - 0.3); // Neutral to slightly acidic
//                 organicCarbon = 1.2 + (Math.random() * 0.4);
//                 nitrogenLevel = 1100 + (int)(Math.random() * 300);
//                 soilType = "Black Cotton";
//                 break;
//             case "Coastal":
//                 soilPH = 7.5 + (Math.random() * 0.5 - 0.2); // Saline coastal
//                 organicCarbon = 1.0 + (Math.random() * 0.3);
//                 nitrogenLevel = 1000 + (int)(Math.random() * 300);
//                 soilType = "Coastal Alluvial";
//                 break;
//             case "Himalayan":
//                 soilPH = 6.2 + (Math.random() * 0.8 - 0.4); // Mountain soil
//                 organicCarbon = 2.0 + (Math.random() * 0.6);
//                 nitrogenLevel = 1400 + (int)(Math.random() * 400);
//                 soilType = "Mountain";
//                 break;
//         }

//         return new SoilAnalysis(null, soilPH, organicCarbon, nitrogenLevel, soilType);
//     }

//     // REALISTIC CLIMATE DATA based on Indian climate zones
//     private ClimateData generateRealisticClimateData(Double lat, Double lon) {
//         String region = getIndianRegion(lat, lon);
//         double temperature = 25.0;
//         int rainfall = 1000;
//         double sunshine = 6.0;
//         String climateZone = "Tropical";

//         // Real Indian climate patterns
//         switch(region) {
//             case "Northern Plains":
//                 temperature = 22.0 + (Math.random() * 8.0 - 4.0); // 18-26°C
//                 rainfall = 800 + (int)(Math.random() * 600); // 800-1400mm
//                 sunshine = 7.0 + (Math.random() * 2.0);
//                 climateZone = "Subtropical";
//                 break;
//             case "Western Dry":
//                 temperature = 28.0 + (Math.random() * 6.0 - 3.0); // 25-31°C
//                 rainfall = 300 + (int)(Math.random() * 300); // 300-600mm
//                 sunshine = 8.0 + (Math.random() * 2.0);
//                 climateZone = "Arid";
//                 break;
//             case "Eastern Plateau":
//                 temperature = 26.0 + (Math.random() * 6.0 - 3.0); // 23-29°C
//                 rainfall = 1200 + (int)(Math.random() * 800); // 1200-2000mm
//                 sunshine = 6.5 + (Math.random() * 1.5);
//                 climateZone = "Humid Subtropical";
//                 break;
//             case "Southern Plateau":
//                 temperature = 28.0 + (Math.random() * 4.0 - 2.0); // 26-30°C
//                 rainfall = 900 + (int)(Math.random() * 600); // 900-1500mm
//                 sunshine = 6.0 + (Math.random() * 2.0);
//                 climateZone = "Tropical Savanna";
//                 break;
//             case "Coastal":
//                 temperature = 30.0 + (Math.random() * 4.0 - 2.0); // 28-32°C
//                 rainfall = 2000 + (int)(Math.random() * 1500); // 2000-3500mm
//                 sunshine = 5.5 + (Math.random() * 1.5);
//                 climateZone = "Tropical Coastal";
//                 break;
//             case "Himalayan":
//                 temperature = 18.0 + (Math.random() * 6.0 - 3.0); // 15-21°C
//                 rainfall = 1500 + (int)(Math.random() * 1000); // 1500-2500mm
//                 sunshine = 6.5 + (Math.random() * 1.5);
//                 climateZone = "Mountain";
//                 break;
//         }

//         return new ClimateData(null, temperature, rainfall, sunshine, climateZone);
//     }

//     // REALISTIC CROP RECOMMENDATIONS based on ICAR data
//     // private Map<String, Object> generateRealisticCropRecommendations(Farmer farmer, SoilAnalysis soil, ClimateData climate) {
//     //     Map<String, Object> result = new HashMap<>();
        
//     //     String region = getIndianRegion(farmer.getLatitude(), farmer.getLongitude());
//     //     List<CropData> suitableCrops = getRegionSpecificCrops(region, soil, climate);
        
//     //     for (CropData cropData : suitableCrops) {
//     //         CropRecommendation recommendation = new CropRecommendation(
//     //             farmer, 
//     //             cropData.name,
//     //             cropData.score,
//     //             cropData.season,
//     //             soil.getSoilPh(),
//     //             climate.getAvgTemperature(),
//     //             climate.getAnnualRainfall(),
//     //             cropData.duration,
//     //             cropData.yield,
//     //             cropData.water
//     //         );
            
//     //         cropRecommendationRepository.save(recommendation);
//     //     }
        
//     //     result.put("farmerId", farmer.getId());
//     //     result.put("soilAnalysis", soil);
//     //     result.put("climateData", climate);
//     //     result.put("region", region);
//     //     result.put("message", "Realistic agricultural analysis completed");
        
//     //     return result;
//     // }
//     // FIXED: Now returns crop recommendations in response
// private Map<String, Object> generateRealisticCropRecommendations(Farmer farmer, SoilAnalysis soil, ClimateData climate) {
//     Map<String, Object> result = new HashMap<>();
    
//     String region = getIndianRegion(farmer.getLatitude(), farmer.getLongitude());
//     List<CropData> suitableCrops = getRegionSpecificCrops(region, soil, climate);
    
//     List<Map<String, Object>> cropRecommendations = new ArrayList<>();
    
//     for (CropData cropData : suitableCrops) {
//         // Save to database
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
        
//         // ALSO add to response for frontend
//         Map<String, Object> cropResponse = new HashMap<>();
//         cropResponse.put("cropName", cropData.name);
//         cropResponse.put("score", cropData.score);
//         cropResponse.put("season", cropData.season);
//         cropResponse.put("duration", cropData.duration);
//         cropResponse.put("yield", cropData.yield);
//         cropResponse.put("waterRequirement", cropData.water);
//         cropRecommendations.add(cropResponse);
//     }
    
//     result.put("farmerId", farmer.getId());
//     result.put("soilAnalysis", soil);
//     result.put("climateData", climate);
//     result.put("region", region);
//     result.put("recommendations", cropRecommendations); // ← THIS WAS MISSING!
//     result.put("message", "Realistic agricultural analysis completed");
    
//     return result;
// }
//     // Get Indian agricultural regions
//     private String getIndianRegion(Double lat, Double lon) {
//         if (lat > 30.0) return "Himalayan";
//         if (lat > 28.0 && lon < 75.0) return "Western Dry";
//         if (lat > 25.0 && lon > 85.0) return "Eastern Plateau";
//         if (lat > 20.0 && lat <= 25.0) return "Northern Plains";
//         if (lat > 15.0 && lat <= 20.0) return "Southern Plateau";
//         if (lat <= 15.0) return "Coastal";
//         return "Central Plains";
//     }

//     // Region-specific crops based on ICAR recommendations
//     private List<CropData> getRegionSpecificCrops(String region, SoilAnalysis soil, ClimateData climate) {
//         List<CropData> crops = new ArrayList<>();
        
//         switch(region) {
//             case "Northern Plains":
//                 crops.add(new CropData("Wheat", calculateScore("Wheat", soil, climate), "Rabi", 120, "4-5 tons/ha", "Medium"));
//                 crops.add(new CropData("Rice", calculateScore("Rice", soil, climate), "Kharif", 90, "4-6 tons/ha", "High"));
//                 crops.add(new CropData("Sugarcane", calculateScore("Sugarcane", soil, climate), "Annual", 365, "70-80 tons/ha", "High"));
//                 crops.add(new CropData("Maize", calculateScore("Maize", soil, climate), "Kharif", 85, "3-4 tons/ha", "Medium"));
//                 crops.add(new CropData("Mustard", calculateScore("Mustard", soil, climate), "Rabi", 110, "1-2 tons/ha", "Low"));
//                 break;
                
//             case "Western Dry":
//                 crops.add(new CropData("Pearl Millet", calculateScore("Pearl Millet", soil, climate), "Kharif", 85, "1-2 tons/ha", "Low"));
//                 crops.add(new CropData("Cluster Bean", calculateScore("Cluster Bean", soil, climate), "Kharif", 90, "0.5-1 ton/ha", "Very Low"));
//                 crops.add(new CropData("Moong Bean", calculateScore("Moong Bean", soil, climate), "Kharif", 65, "0.5-1 ton/ha", "Low"));
//                 crops.add(new CropData("Guar", calculateScore("Guar", soil, climate), "Kharif", 95, "1-2 tons/ha", "Very Low"));
//                 crops.add(new CropData("Isabgol", calculateScore("Isabgol", soil, climate), "Rabi", 110, "1-1.5 tons/ha", "Low"));
//                 break;
                
//             case "Eastern Plateau":
//                 crops.add(new CropData("Rice", calculateScore("Rice", soil, climate), "Kharif", 90, "3-5 tons/ha", "High"));
//                 crops.add(new CropData("Pulses", calculateScore("Pulses", soil, climate), "Rabi", 100, "1-2 tons/ha", "Low"));
//                 crops.add(new CropData("Oilseeds", calculateScore("Oilseeds", soil, climate), "Rabi", 110, "1-2 tons/ha", "Low"));
//                 crops.add(new CropData("Maize", calculateScore("Maize", soil, climate), "Kharif", 85, "2-3 tons/ha", "Medium"));
//                 crops.add(new CropData("Vegetables", calculateScore("Vegetables", soil, climate), "Year-round", 60, "15-20 tons/ha", "High"));
//                 break;
                
//             case "Southern Plateau":
//                 crops.add(new CropData("Cotton", calculateScore("Cotton", soil, climate), "Kharif", 150, "2-3 tons/ha", "Medium"));
//                 crops.add(new CropData("Groundnut", calculateScore("Groundnut", soil, climate), "Kharif", 105, "1-2 tons/ha", "Low"));
//                 crops.add(new CropData("Sunflower", calculateScore("Sunflower", soil, climate), "Rabi", 95, "1-2 tons/ha", "Low"));
//                 crops.add(new CropData("Sugarcane", calculateScore("Sugarcane", soil, climate), "Annual", 365, "80-100 tons/ha", "High"));
//                 crops.add(new CropData("Sorghum", calculateScore("Sorghum", soil, climate), "Kharif", 90, "2-3 tons/ha", "Low"));
//                 break;
                
//             case "Coastal":
//                 crops.add(new CropData("Coconut", calculateScore("Coconut", soil, climate), "Annual", 365, "80-100 nuts/tree", "Medium"));
//                 crops.add(new CropData("Rice", calculateScore("Rice", soil, climate), "Kharif", 90, "5-7 tons/ha", "High"));
//                 crops.add(new CropData("Banana", calculateScore("Banana", soil, climate), "Annual", 365, "40-50 tons/ha", "High"));
//                 crops.add(new CropData("Black Pepper", calculateScore("Black Pepper", soil, climate), "Annual", 365, "500-800 kg/ha", "Medium"));
//                 crops.add(new CropData("Cashew", calculateScore("Cashew", soil, climate), "Annual", 365, "1-2 tons/ha", "Low"));
//                 break;
                
//             case "Himalayan":
//                 crops.add(new CropData("Apple", calculateScore("Apple", soil, climate), "Annual", 365, "15-20 tons/ha", "Medium"));
//                 crops.add(new CropData("Potato", calculateScore("Potato", soil, climate), "Rabi", 100, "20-25 tons/ha", "High"));
//                 crops.add(new CropData("Maize", calculateScore("Maize", soil, climate), "Kharif", 85, "2-3 tons/ha", "Medium"));
//                 crops.add(new CropData("Saffron", calculateScore("Saffron", soil, climate), "Annual", 365, "2-3 kg/ha", "Low"));
//                 crops.add(new CropData("Raju", calculateScore("Raju", soil, climate), "Kharif", 75, "1-2 tons/ha", "Low"));
//                 break;
                
//             default: // Central Plains
//                 crops.add(new CropData("Wheat", calculateScore("Wheat", soil, climate), "Rabi", 120, "3-4 tons/ha", "Medium"));
//                 crops.add(new CropData("Rice", calculateScore("Rice", soil, climate), "Kharif", 90, "4-5 tons/ha", "High"));
//                 crops.add(new CropData("Soybean", calculateScore("Soybean", soil, climate), "Kharif", 95, "2-3 tons/ha", "Medium"));
//                 crops.add(new CropData("Gram", calculateScore("Gram", soil, climate), "Rabi", 100, "1-2 tons/ha", "Low"));
//                 crops.add(new CropData("Maize", calculateScore("Maize", soil, climate), "Kharif", 85, "3-4 tons/ha", "Medium"));
//         }
        
//         // Sort by score and take top 5
//         crops.sort((a, b) -> Integer.compare(b.score, a.score));
//         return crops.subList(0, Math.min(5, crops.size()));
//     }

//     // Realistic crop scoring based on agricultural science
//     private int calculateScore(String cropName, SoilAnalysis soil, ClimateData climate) {
//         int score = 100;
//         double soilPH = soil.getSoilPh();
//         double temperature = climate.getAvgTemperature();
//         int rainfall = climate.getAnnualRainfall();
//         double organicCarbon = soil.getOrganicCarbon();

//         // Crop-specific requirements based on agricultural research
//         switch (cropName) {
//             case "Rice":
//                 if (soilPH < 5.5 || soilPH > 7.0) score -= 30;
//                 if (temperature < 20 || temperature > 35) score -= 25;
//                 if (rainfall < 1000) score -= 20;
//                 if (organicCarbon < 1.0) score -= 15;
//                 break;
//             case "Wheat":
//                 if (soilPH < 6.0 || soilPH > 7.5) score -= 30;
//                 if (temperature < 10 || temperature > 25) score -= 25;
//                 if (rainfall < 500) score -= 20;
//                 if (organicCarbon < 1.2) score -= 10;
//                 break;
//             case "Sugarcane":
//                 if (soilPH < 6.5 || soilPH > 7.5) score -= 25;
//                 if (temperature < 20 || temperature > 35) score -= 20;
//                 if (rainfall < 1500) score -= 30;
//                 if (organicCarbon < 1.5) score -= 15;
//                 break;
//             case "Cotton":
//                 if (soilPH < 6.0 || soilPH > 8.0) score -= 20;
//                 if (temperature < 21 || temperature > 35) score -= 25;
//                 if (rainfall < 500) score -= 15;
//                 if (organicCarbon < 1.0) score -= 10;
//                 break;
//             case "Pearl Millet":
//                 if (soilPH < 6.5 || soilPH > 8.5) score -= 15;
//                 if (temperature < 25 || temperature > 35) score -= 20;
//                 if (rainfall > 800) score -= 25; // Doesn't like too much rain
//                 if (organicCarbon < 0.8) score -= 10;
//                 break;
//             case "Apple":
//                 if (soilPH < 5.5 || soilPH > 6.5) score -= 30;
//                 if (temperature < 15 || temperature > 25) score -= 35;
//                 if (rainfall < 1000) score -= 20;
//                 if (organicCarbon < 2.0) score -= 20;
//                 break;
//             case "Coconut":
//                 if (soilPH < 5.0 || soilPH > 8.0) score -= 20;
//                 if (temperature < 20 || temperature > 35) score -= 25;
//                 if (rainfall < 1500) score -= 30;
//                 if (organicCarbon < 1.0) score -= 10;
//                 break;
//             default:
//                 // Generic scoring for other crops
//                 if (soilPH < 6.0 || soilPH > 7.5) score -= 20;
//                 if (temperature < 15 || temperature > 32) score -= 20;
//                 if (rainfall < 500) score -= 15;
//                 if (organicCarbon < 1.0) score -= 10;
//         }
        
//         // Add small randomness for natural variation
//         score += (int)(Math.random() * 10) - 5;
        
//         return Math.max(40, Math.min(100, score)); // Keep between 40-100
//     }

//     // Helper class for crop data
//     class CropData {
//         String name;
//         int score;
//         String season;
//         int duration;
//         String yield;
//         String water;
        
//         CropData(String name, int score, String season, int duration, String yield, String water) {
//             this.name = name;
//             this.score = score;
//             this.season = season;
//             this.duration = duration;
//             this.yield = yield;
//             this.water = water;
//         }
//     }
// }

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

        // Step 2: Generate soil data (EXACTLY like your frontend logic)
        SoilAnalysis soilAnalysis = getLocationSpecificSoilData(latitude, longitude);
        soilAnalysis.setFarmer(savedFarmer);
        SoilAnalysis savedSoil = soilAnalysisRepository.save(soilAnalysis);

        // Step 3: Generate climate data (EXACTLY like your frontend logic)
        ClimateData climateData = getLocationSpecificClimateData(latitude, longitude);
        climateData.setFarmer(savedFarmer);
        ClimateData savedClimate = climateDataRepository.save(climateData);

        // Step 4: Generate crop recommendations (EXACTLY like your frontend logic)
        List<Map<String, Object>> recommendations = analyzeLocationSpecificCrops(soilAnalysis, climateData, latitude, longitude);

        // Step 5: Save recommendations to database
        for (Map<String, Object> rec : recommendations) {
            CropRecommendation cropRec = new CropRecommendation();
            cropRec.setFarmer(savedFarmer);
            cropRec.setCropName((String) rec.get("cropName"));
            cropRec.setSuitabilityScore((Integer) rec.get("score"));
            cropRec.setSeason((String) rec.get("season"));
            cropRec.setSoilPh(soilAnalysis.getSoilPh());
            cropRec.setTemperature(climateData.getAvgTemperature());
            cropRec.setRainfall(climateData.getAnnualRainfall());
            cropRec.setDurationDays((Integer) rec.get("duration"));
            cropRec.setExpectedYield((String) rec.get("yield"));
            cropRec.setWaterRequirement((String) rec.get("waterRequirement"));
            
            cropRecommendationRepository.save(cropRec);
        }

        // Step 6: Prepare response
        Map<String, Object> result = new HashMap<>();
        result.put("farmerId", savedFarmer.getId());
        result.put("farmerName", farmerName);
        result.put("latitude", latitude);
        result.put("longitude", longitude);
        result.put("soilAnalysis", savedSoil);
        result.put("climateData", savedClimate);
        result.put("region", getIndianRegion(latitude, longitude));
        result.put("recommendations", recommendations);
        result.put("message", "Agricultural analysis completed successfully");

        return result;
    }

    // EXACTLY like your frontend getLocationSpecificSoilData()
    private SoilAnalysis getLocationSpecificSoilData(Double lat, Double lon) {
        double soilPh, organicCarbon, nitrogenLevel;
        String soilType;

        // Real Indian soil patterns
        if (lat > 30.0) {
            // Himalayan region
            soilPh = 6.2;
            organicCarbon = 2.0;
            nitrogenLevel = 1400;
            soilType = "Mountain Soil";
        } else if (lat > 28.0 && lon < 75.0) {
            // Western Dry region (Rajasthan)
            soilPh = 8.0;
            organicCarbon = 0.8;
            nitrogenLevel = 800;
            soilType = "Desert Soil";
        } else if (lat > 25.0 && lon > 85.0) {
            // Eastern region
            soilPh = 6.0;
            organicCarbon = 1.5;
            nitrogenLevel = 1300;
            soilType = "Red Soil";
        } else if (lat > 20.0 && lat <= 25.0) {
            // Northern Plains
            soilPh = 7.2;
            organicCarbon = 1.8;
            nitrogenLevel = 1500;
            soilType = "Alluvial Soil";
        } else if (lat > 15.0 && lat <= 20.0) {
            // Southern Plateau
            soilPh = 6.8;
            organicCarbon = 1.2;
            nitrogenLevel = 1100;
            soilType = "Black Cotton Soil";
        } else {
            // Coastal region
            soilPh = 7.5;
            organicCarbon = 1.0;
            nitrogenLevel = 1000;
            soilType = "Coastal Alluvial";
        }

        // Add small variations like your frontend
        soilPh += (Math.random() * 0.4 - 0.2);
        organicCarbon += (Math.random() * 0.3 - 0.15);
        nitrogenLevel += (int)(Math.random() * 200 - 100);

        return new SoilAnalysis(null, soilPh, organicCarbon, (int) Math.round(nitrogenLevel), soilType, lat, lon);
    }

    // EXACTLY like your frontend getLocationSpecificClimateData()
    private ClimateData getLocationSpecificClimateData(Double lat, Double lon) {
        double avgTemperature, sunshineHours;
        int annualRainfall;
        String climateZone;

        // Real Indian climate patterns
        if (lat > 30.0) {
            // Himalayan
            avgTemperature = 18.0;
            annualRainfall = 1500;
            sunshineHours = 6.5;
            climateZone = "Mountain";
        } else if (lat > 28.0 && lon < 75.0) {
            // Western Dry
            avgTemperature = 28.0;
            annualRainfall = 300;
            sunshineHours = 8.0;
            climateZone = "Arid";
        } else if (lat > 25.0 && lon > 85.0) {
            // Eastern
            avgTemperature = 26.0;
            annualRainfall = 1200;
            sunshineHours = 6.5;
            climateZone = "Humid Subtropical";
        } else if (lat > 20.0 && lat <= 25.0) {
            // Northern Plains
            avgTemperature = 22.0;
            annualRainfall = 800;
            sunshineHours = 7.0;
            climateZone = "Subtropical";
        } else if (lat > 15.0 && lat <= 20.0) {
            // Southern Plateau
            avgTemperature = 28.0;
            annualRainfall = 900;
            sunshineHours = 6.0;
            climateZone = "Tropical Savanna";
        } else {
            // Coastal
            avgTemperature = 30.0;
            annualRainfall = 2000;
            sunshineHours = 5.5;
            climateZone = "Tropical Coastal";
        }

        // Add small variations like your frontend
        avgTemperature += (Math.random() * 4 - 2);
        annualRainfall += (int)(Math.random() * 200 - 100);
        sunshineHours += (Math.random() * 1 - 0.5);

        // Generate monthly data for chart
        double[] monthlyTemp = new double[12];
        double[] monthlyRain = new double[12];
        
        for (int i = 0; i < 12; i++) {
            double baseTemp = avgTemperature;
            double variation = Math.sin(i * 0.5) * 8;
            monthlyTemp[i] = baseTemp + variation;
            
            // Monsoon pattern for India
            if (i >= 5 && i <= 9) {
                monthlyRain[i] = annualRainfall * 0.15;
            } else {
                monthlyRain[i] = annualRainfall * 0.05;
            }
        }

        ClimateData climateData = new ClimateData(null, avgTemperature, annualRainfall, sunshineHours, climateZone);
        climateData.setMonthlyTemp(monthlyTemp);
        climateData.setMonthlyRain(monthlyRain);
        
        return climateData;
    }

    // EXACTLY like your frontend analyzeLocationSpecificCrops()
    private List<Map<String, Object>> analyzeLocationSpecificCrops(SoilAnalysis soilData, ClimateData climateData, Double lat, Double lon) {
        System.out.println("🌾 Dynamic crop analysis for location: " + lat + ", " + lon);
        
        // Get all available crops
        List<Crop> allCrops = getAllAvailableCrops();
        List<Map<String, Object>> scoredCrops = new ArrayList<>();
        
        for (Crop crop : allCrops) {
            int score = 100;
            List<String> factors = new ArrayList<>();
            
            // 1. Soil pH suitability (25% weight)
            double phDiff = Math.abs(soilData.getSoilPh() - crop.idealPH);
            int phScore = Math.max(0, 100 - (int)(phDiff * 20));
            score = (int)((score * 0.75) + (phScore * 0.25));
            factors.add("pH: " + phScore + "%");
            
            // 2. Temperature suitability (30% weight)
            double tempDiff = Math.abs(climateData.getAvgTemperature() - crop.idealTemp);
            int tempScore = Math.max(0, 100 - (int)(tempDiff * 4));
            score = (int)((score * 0.70) + (tempScore * 0.30));
            factors.add("Temp: " + tempScore + "%");
            
            // 3. Rainfall suitability (25% weight)
            double rainDiff = Math.abs(climateData.getAnnualRainfall() - crop.idealRainfall);
            double rainRatio = rainDiff / crop.idealRainfall;
            int rainScore = Math.max(0, 100 - (int)(rainRatio * 50));
            score = (int)((score * 0.75) + (rainScore * 0.25));
            factors.add("Rain: " + rainScore + "%");
            
            // 4. Regional bonus (20% weight)
            int regionBonus = getRegionalBonus(crop.name, lat, lon);
            score = (int)((score * 0.80) + (regionBonus * 0.20));
            factors.add("Region: " + regionBonus + "%");
            
            // Only include crops with decent suitability
            if (score >= 40) {
                Map<String, Object> cropRec = new HashMap<>();
                cropRec.put("cropName", crop.name);
                cropRec.put("score", score);
                cropRec.put("season", crop.season);
                cropRec.put("duration", crop.duration);
                cropRec.put("yield", crop.yield);
                cropRec.put("waterRequirement", crop.waterRequirement);
                cropRec.put("factors", factors);
                cropRec.put("suitability", getSuitabilityLevel(score));
                
                scoredCrops.add(cropRec);
            }
        }
        
        // Sort by score and return top 6
        scoredCrops.sort((a, b) -> Integer.compare((Integer)b.get("score"), (Integer)a.get("score")));
        return scoredCrops.subList(0, Math.min(6, scoredCrops.size()));
    }

    // EXACTLY like your frontend getAllAvailableCrops()
    private List<Crop> getAllAvailableCrops() {
        List<Crop> crops = new ArrayList<>();
        
        // Cereals
        crops.add(new Crop("Rice", 6.2, 25, 1500, "Kharif", 90, "4-6 tons/ha", "High"));
        crops.add(new Crop("Wheat", 6.8, 17, 750, "Rabi", 120, "3-5 tons/ha", "Medium"));
        crops.add(new Crop("Maize", 6.5, 22, 800, "Kharif", 85, "2-4 tons/ha", "Medium"));
        crops.add(new Crop("Pearl Millet", 7.5, 30, 400, "Kharif", 85, "1-2 tons/ha", "Low"));
        crops.add(new Crop("Sorghum", 7.0, 30, 450, "Kharif", 90, "2-3 tons/ha", "Low"));
        
        // Pulses
        crops.add(new Crop("Chickpea", 6.8, 20, 600, "Rabi", 100, "1-2 tons/ha", "Low"));
        crops.add(new Crop("Pigeon Pea", 6.5, 26, 700, "Kharif", 150, "1-1.5 tons/ha", "Low"));
        crops.add(new Crop("Moong Bean", 7.0, 28, 500, "Kharif", 65, "0.5-1 ton/ha", "Low"));
        crops.add(new Crop("Urad Bean", 6.8, 25, 600, "Kharif", 80, "0.5-1 ton/ha", "Low"));
        crops.add(new Crop("Lentil", 6.5, 18, 500, "Rabi", 110, "0.8-1.2 tons/ha", "Low"));
        
        // Oilseeds
        crops.add(new Crop("Mustard", 6.8, 18, 500, "Rabi", 110, "1-2 tons/ha", "Low"));
        crops.add(new Crop("Groundnut", 6.5, 28, 600, "Kharif", 105, "1-2 tons/ha", "Low"));
        crops.add(new Crop("Sunflower", 6.8, 25, 500, "Rabi", 95, "1-2 tons/ha", "Low"));
        crops.add(new Crop("Soybean", 6.5, 24, 600, "Kharif", 100, "1.5-2.5 tons/ha", "Medium"));
        
        // Cash Crops
        crops.add(new Crop("Cotton", 7.0, 28, 650, "Kharif", 150, "2-3 tons/ha", "Medium"));
        crops.add(new Crop("Sugarcane", 7.0, 27, 2000, "Annual", 365, "70-100 tons/ha", "High"));
        crops.add(new Crop("Jute", 6.5, 26, 1800, "Kharif", 120, "2-3 tons/ha", "High"));
        
        // Fruits
        crops.add(new Crop("Mango", 6.5, 27, 1200, "Annual", 365, "8-10 tons/ha", "Medium"));
        crops.add(new Crop("Banana", 6.5, 27, 2000, "Annual", 365, "40-50 tons/ha", "High"));
        crops.add(new Crop("Apple", 6.0, 15, 1200, "Annual", 365, "15-20 tons/ha", "Medium"));
        crops.add(new Crop("Orange", 6.5, 23, 1000, "Annual", 365, "10-15 tons/ha", "Medium"));
        
        // Vegetables
        crops.add(new Crop("Potato", 5.5, 18, 1000, "Rabi", 100, "20-25 tons/ha", "High"));
        crops.add(new Crop("Tomato", 6.5, 22, 800, "Year-round", 90, "25-30 tons/ha", "Medium"));
        crops.add(new Crop("Onion", 6.8, 20, 600, "Rabi", 120, "15-20 tons/ha", "Medium"));
        crops.add(new Crop("Brinjal", 6.5, 25, 700, "Year-round", 100, "20-25 tons/ha", "Medium"));
        
        return crops;
    }

    // EXACTLY like your frontend getRegionalBonus()
    private int getRegionalBonus(String cropName, Double lat, Double lon) {
        Map<String, Integer> regionalPreferences = new HashMap<>();
        
        // Himalayan crops
        regionalPreferences.put("Apple", lat > 30 ? 100 : 40);
        regionalPreferences.put("Saffron", lat > 30 ? 100 : 30);
        regionalPreferences.put("Potato", lat > 25 ? 80 : 60);
        
        // Dry region crops
        regionalPreferences.put("Pearl Millet", (lat > 28 && lon < 75) ? 100 : 50);
        regionalPreferences.put("Cluster Bean", (lat > 28 && lon < 75) ? 100 : 40);
        regionalPreferences.put("Guar", (lat > 28 && lon < 75) ? 100 : 45);
        
        // Eastern crops
        regionalPreferences.put("Jute", (lat > 25 && lon > 85) ? 100 : 60);
        regionalPreferences.put("Pigeon Pea", (lat > 25 && lon > 85) ? 90 : 70);
        
        // Northern plains crops
        regionalPreferences.put("Wheat", (lat > 20 && lat <= 25) ? 100 : 70);
        regionalPreferences.put("Sugarcane", (lat > 20 && lat <= 25) ? 95 : 65);
        regionalPreferences.put("Mustard", (lat > 20 && lat <= 25) ? 90 : 60);
        
        // Southern crops
        regionalPreferences.put("Cotton", (lat > 15 && lat <= 20) ? 100 : 70);
        regionalPreferences.put("Groundnut", (lat > 15 && lat <= 20) ? 95 : 65);
        regionalPreferences.put("Sorghum", (lat > 15 && lat <= 20) ? 90 : 60);
        
        // Coastal crops
        regionalPreferences.put("Coconut", lat <= 15 ? 100 : 50);
        regionalPreferences.put("Black Pepper", lat <= 15 ? 100 : 40);
        regionalPreferences.put("Arecanut", lat <= 15 ? 100 : 30);
        regionalPreferences.put("Banana", lat <= 15 ? 95 : 70);
        regionalPreferences.put("Cardamom", (lat <= 15 || lat > 25) ? 80 : 50);
        
        return regionalPreferences.getOrDefault(cropName, 70);
    }

    private String getSuitabilityLevel(int score) {
        if (score >= 80) return "Excellent";
        if (score >= 60) return "Good";
        if (score >= 40) return "Moderate";
        return "Poor";
    }

    private String getIndianRegion(Double lat, Double lon) {
        if (lat > 30.0) return "Himalayan";
        if (lat > 28.0 && lon < 75.0) return "Western Dry";
        if (lat > 25.0 && lon > 85.0) return "Eastern Plateau";
        if (lat > 20.0 && lat <= 25.0) return "Northern Plains";
        if (lat > 15.0 && lat <= 20.0) return "Southern Plateau";
        if (lat <= 15.0) return "Coastal";
        return "Central Plains";
    }

    // Helper class for crop data
    class Crop {
        String name;
        double idealPH;
        double idealTemp;
        int idealRainfall;
        String season;
        int duration;
        String yield;
        String waterRequirement;
        
        Crop(String name, double idealPH, double idealTemp, int idealRainfall, 
             String season, int duration, String yield, String waterRequirement) {
            this.name = name;
            this.idealPH = idealPH;
            this.idealTemp = idealTemp;
            this.idealRainfall = idealRainfall;
            this.season = season;
            this.duration = duration;
            this.yield = yield;
            this.waterRequirement = waterRequirement;
        }
    }
}