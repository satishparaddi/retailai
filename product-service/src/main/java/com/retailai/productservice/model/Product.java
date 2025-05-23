package com.retailai.productservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    private Integer quantity;

    @Column(name = "image_url")
    private String imageUrl;

    private String screenSize;     // e.g., "55 inch"
    private String resolution;     // e.g., "4K UHD"
    private String refreshRate;    // e.g., "60Hz"

    @ElementCollection
    @CollectionTable(name = "product_features", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "feature")
    private List<String> smartFeatures;  // e.g., Alexa, HDR10+, Tizen OS
}
