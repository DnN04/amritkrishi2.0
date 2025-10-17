package com.amritkrishi.repository;

import com.amritkrishi.model.CropRecommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CropRecommendationRepository extends JpaRepository<CropRecommendation, Long> {
    List<CropRecommendation> findByFarmerId(Long farmerId);
}