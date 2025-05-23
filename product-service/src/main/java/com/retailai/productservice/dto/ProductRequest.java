package com.retailai.productservice.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.URL;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @URL(message = "Invalid image URL")
    private String imageUrl;

    private String description;


    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal price;

    @NotBlank
    private String screenSize;

    @NotBlank
    private String resolution;

    @NotBlank
    private String refreshRate;

    private List<String> smartFeatures;


    @NotNull
    @Min(0)
    private Integer quantity;
}
