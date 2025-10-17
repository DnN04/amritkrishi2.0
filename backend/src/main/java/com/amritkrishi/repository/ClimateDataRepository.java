package com.amritkrishi.repository;

import com.amritkrishi.model.ClimateData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClimateDataRepository extends JpaRepository<ClimateData, Long> {
    ClimateData findByFarmerId(Long farmerId);
}