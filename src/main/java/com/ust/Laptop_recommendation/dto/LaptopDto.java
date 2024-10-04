package com.ust.Laptop_recommendation.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LaptopDto {

    @NotBlank(message = "Brand is mandatory")
    private String company;

    @NotBlank(message = "Model is mandatory")
    private String model;

    @Min(value = 1, message = "Price should be greater than 1")
    private Double price;

    @NotBlank(message = "Processor is mandatory")
    private String processor;

    @NotNull(message = "RAM is mandatory")
    @Min(value = 1, message = "RAM should be greater than 0")
    private Integer ram;

    @NotNull(message = "Storage is mandatory")
    @Min(value = 1, message = "Storage should be greater than 0")
    private Integer storage;
}
