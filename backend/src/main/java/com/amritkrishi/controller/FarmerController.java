package com.amritkrishi.controller;

import com.amritkrishi.model.Farmer;
import com.amritkrishi.service.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/farmers")
@CrossOrigin(origins = "*") // Allow all origins for development
public class FarmerController {
    
    @Autowired
    private FarmerService farmerService;
    
    @PostMapping
    public ResponseEntity<Farmer> saveFarmer(@RequestBody Farmer farmer) {
        Farmer savedFarmer = farmerService.saveFarmer(farmer);
        return ResponseEntity.ok(savedFarmer);
    }
    
    @GetMapping
    public ResponseEntity<List<Farmer>> getAllFarmers() {
        List<Farmer> farmers = farmerService.getAllFarmers();
        return ResponseEntity.ok(farmers);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Farmer> getFarmerById(@PathVariable Long id) {
        Farmer farmer = farmerService.getFarmerById(id);
        return ResponseEntity.ok(farmer);
    }
}