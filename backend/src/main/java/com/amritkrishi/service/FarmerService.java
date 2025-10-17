package com.amritkrishi.service;

import com.amritkrishi.model.Farmer;
import com.amritkrishi.repository.FarmerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FarmerService {

    @Autowired
    private FarmerRepository farmerRepository;

    public Farmer saveFarmer(Farmer farmer) {
        return farmerRepository.save(farmer);
    }

    public List<Farmer> getAllFarmers() {
        return farmerRepository.findAll();
    }

    public Farmer getFarmerById(Long id) {
        Optional<Farmer> farmer = farmerRepository.findById(id);
        return farmer.orElse(null);
    }

    public Farmer getLatestFarmer() {
        List<Farmer> farmers = farmerRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        return farmers.isEmpty() ? null : farmers.get(0);
    }

    public void deleteFarmer(Long id) {
        farmerRepository.deleteById(id);
    }
}