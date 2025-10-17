SQL TABLE:
CREATE DATABASE amritkrishi;

USE amritkrishi;

-- Table for farmer information and location
CREATE TABLE farmers (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    farmer_name VARCHAR(255) NOT NULL,
    latitude DECIMAL(10, 8) NOT NULL,
    longitude DECIMAL(11, 8) NOT NULL,
    location_method VARCHAR(50),
    address TEXT,
    preferred_language VARCHAR(10) DEFAULT 'en',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Continue with the rest of the CREATE TABLE statements...

to check:
-- See all data
SELECT * FROM amritkrishi.farmers;
SELECT * FROM amritkrishi.crop_recommendations;
SELECT * FROM amritkrishi.soil_analysis;
SELECT * FROM amritkrishi.climate_data;

-- See farmer with their crop recommendations
SELECT f.farmer_name, f.latitude, f.longitude, c.crop_name, c.suitability_score
FROM farmers f
LEFT JOIN crop_recommendations c ON f.id = c.farmer_id;