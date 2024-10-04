package com.ust.Laptop_recommendation.service;

import com.speedment.jpastreamer.application.JPAStreamer;
import com.ust.Laptop_recommendation.dto.LaptopDto;
import com.ust.Laptop_recommendation.model.LaptopModel;
import com.ust.Laptop_recommendation.repo.LaptopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopService {

    @Autowired
    private LaptopRepo repo;

    private final JPAStreamer jpaStreamer;

    @Autowired
    public LaptopService(JPAStreamer jpastreamer) {
        this.jpaStreamer = jpastreamer;
    }

    public LaptopModel addLaptop(LaptopDto dto){
        LaptopModel model = new LaptopModel();
        model.setCompany(dto.getCompany());
        model.setModel(dto.getModel());
        model.setPrice(dto.getPrice());
        model.setProcessor(dto.getProcessor());
        model.setRam(dto.getRam());
        model.setStorage(dto.getStorage());
        return repo.save(model);
    }

    public List<LaptopModel> getAllLaptop() {
        return repo.findAll();
    }

    // New method to filter laptops based on user input
    public List<LaptopModel> recommendLaptops(Double maxPrice, String processor, Integer minRam, Integer minStorage) {
        return jpaStreamer.stream(LaptopModel.class)
                .filter(laptop -> (maxPrice == null || laptop.getPrice() <= maxPrice) &&
                        (processor == null || laptop.getProcessor().equalsIgnoreCase(processor)) &&
                        (minRam == null || laptop.getRam() >= minRam) &&
                        (minStorage == null || laptop.getStorage() >= minStorage))
                .toList();
    }
}
