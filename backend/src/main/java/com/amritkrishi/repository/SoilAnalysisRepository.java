package com.amritkrishi.repository;

import com.amritkrishi.model.SoilAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoilAnalysisRepository extends JpaRepository<SoilAnalysis, Long> {
    SoilAnalysis findByFarmerId(Long farmerId);
}