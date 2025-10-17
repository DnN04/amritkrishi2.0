package com.amritkrishi.controller;

import com.amritkrishi.model.Farmer;
import com.amritkrishi.model.CropRecommendation;
import com.amritkrishi.service.FarmerService;
import com.amritkrishi.service.AnalysisService;
import com.amritkrishi.repository.CropRecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/analysis")
@CrossOrigin(origins = "*")
public class AnalysisController {
    
    @Autowired
    private AnalysisService analysisService;
    
    @Autowired
    private FarmerService farmerService;
    
    @Autowired
    private CropRecommendationRepository cropRecommendationRepository;
    
    // GET endpoint for testing
    @GetMapping("/test")
    public ResponseEntity<String> testAnalysis() {
        return ResponseEntity.ok("✅ Analysis endpoint is working! Backend is ready.");
    }
    
    @PostMapping("/recommend")
    public ResponseEntity<?> analyzeAndRecommend(@RequestBody Map<String, Object> requestData) {
        try {
            // Extract data from your frontend
            String farmerName = (String) requestData.get("farmerName");
            Double latitude = (Double) requestData.get("latitude");
            Double longitude = (Double) requestData.get("longitude");
            String locationMethod = (String) requestData.get("locationMethod");
            
            // Save farmer and get analysis
            Map<String, Object> recommendations = analysisService.analyzeAndRecommend(
                farmerName, latitude, longitude, locationMethod);
            
            return ResponseEntity.ok(recommendations);
            
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error in analysis: " + e.getMessage());
        }
    }
    
    @PostMapping("/save-recommendations")
    public ResponseEntity<?> saveRecommendations(@RequestBody Map<String, Object> requestData) {
        try {
            System.out.println("💾 Saving recommendations to database...");
            
            // Extract data from request
            Long farmerId = Long.valueOf(requestData.get("farmerId").toString());
            String farmerName = (String) requestData.get("farmerName");
            List<Map<String, Object>> recommendations = (List<Map<String, Object>>) requestData.get("recommendations");
            
            // Get farmer from database
            Farmer farmer = farmerService.getFarmerById(farmerId);
            if (farmer == null) {
                return ResponseEntity.badRequest().body("Farmer not found with ID: " + farmerId);
            }
            
            // Save each recommendation
            List<CropRecommendation> savedRecommendations = new ArrayList<>();
            for (Map<String, Object> rec : recommendations) {
                CropRecommendation recommendation = new CropRecommendation();
                recommendation.setFarmer(farmer);
                recommendation.setCropName((String) rec.get("cropName"));
                
                // Handle different number types safely
                Object scoreObj = rec.get("score");
                if (scoreObj != null) {
                    recommendation.setSuitabilityScore(Integer.valueOf(scoreObj.toString()));
                }
                
                recommendation.setSeason((String) rec.get("season"));
                
                Object soilPhObj = rec.get("soilPh");
                if (soilPhObj != null) {
                    recommendation.setSoilPh(Double.valueOf(soilPhObj.toString()));
                }
                
                Object tempObj = rec.get("temperature");
                if (tempObj != null) {
                    recommendation.setTemperature(Double.valueOf(tempObj.toString()));
                }
                
                Object rainObj = rec.get("rainfall");
                if (rainObj != null) {
                    recommendation.setRainfall(Integer.valueOf(rainObj.toString()));
                }
                
                Object durationObj = rec.get("durationDays");
                if (durationObj != null) {
                    recommendation.setDurationDays(Integer.valueOf(durationObj.toString()));
                }
                
                recommendation.setExpectedYield((String) rec.get("expectedYield"));
                recommendation.setWaterRequirement((String) rec.get("waterRequirement"));
                
                CropRecommendation saved = cropRecommendationRepository.save(recommendation);
                savedRecommendations.add(saved);
            }
            
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Recommendations saved successfully!");
            response.put("savedCount", savedRecommendations.size());
            response.put("farmerId", farmerId);
            response.put("farmerName", farmerName);
            
            System.out.println("✅ Saved " + savedRecommendations.size() + " recommendations for farmer: " + farmerName);
            
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            System.err.println("❌ Error saving recommendations: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error saving recommendations: " + e.getMessage());
        }
    }
    
    // GET endpoint to see all recommendations
    @GetMapping("/recommendations")
    public ResponseEntity<List<CropRecommendation>> getAllRecommendations() {
        List<CropRecommendation> recommendations = cropRecommendationRepository.findAll();
        return ResponseEntity.ok(recommendations);
    }
}