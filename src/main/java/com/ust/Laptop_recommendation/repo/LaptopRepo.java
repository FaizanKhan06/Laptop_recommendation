package com.ust.Laptop_recommendation.repo;

import com.ust.Laptop_recommendation.model.LaptopModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LaptopRepo extends JpaRepository<LaptopModel, UUID> {
}
