package com.ust.Laptop_recommendation.controller;

import com.ust.Laptop_recommendation.dto.LaptopDto;
import com.ust.Laptop_recommendation.model.LaptopModel;
import com.ust.Laptop_recommendation.service.LaptopService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Laptop")
public class LaptopController {

    @Autowired
    private LaptopService service;

    @PostMapping("/addLaptop")
    public ResponseEntity<LaptopModel> addLaptop(@RequestBody @Valid LaptopDto dto) {
        return new ResponseEntity<>(service.addLaptop(dto), HttpStatus.CREATED);
    }

    @GetMapping("/getAllLaptop")
    public List<LaptopModel> getAllLaptop() {
        return service.getAllLaptop();
    }

    // New endpoint for recommending laptops based on user input
    @GetMapping("/recommend")
    public ResponseEntity<List<LaptopModel>> recommendLaptops(
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) String processor,
            @RequestParam(required = false) Integer minRam,
            @RequestParam(required = false) Integer minStorage) {

        List<LaptopModel> recommendations = service.recommendLaptops(maxPrice, processor, minRam, minStorage);
        return new ResponseEntity<>(recommendations, HttpStatus.OK);
    }
}
