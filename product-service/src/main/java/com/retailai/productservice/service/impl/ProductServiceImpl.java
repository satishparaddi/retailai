package com.retailai.productservice.service.impl;

import com.retailai.productservice.dto.ProductRequest;
import com.retailai.productservice.dto.ProductResponse;
import com.retailai.productservice.exception.ProductNotFoundException;
import com.retailai.productservice.model.Product;
import com.retailai.productservice.repository.ProductRepository;
import com.retailai.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductResponse createProduct(ProductRequest request) {
        Product product = Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .quantity(request.getQuantity())
                .imageUrl(request.getImageUrl())
                .screenSize(request.getScreenSize())
                .resolution(request.getResolution())
                .refreshRate(request.getRefreshRate())
                .smartFeatures(request.getSmartFeatures())
                .build();


        Product saved = productRepository.save(product);

        return ProductResponse.builder()
                .id(saved.getId())
                .name(saved.getName())
                .description(saved.getDescription())
                .price(saved.getPrice())
                .quantity(saved.getQuantity())
                .imageUrl(saved.getImageUrl())
                .screenSize(saved.getScreenSize())
                .resolution(saved.getResolution())
                .refreshRate(saved.getRefreshRate())
                .smartFeatures(saved.getSmartFeatures())
                .build();




    }

    @Override
    public List<ProductResponse> getAllProducts(String name) {
        List<Product> products = (name != null && !name.isEmpty())
                ? productRepository.findByNameContainingIgnoreCase(name)
                : productRepository.findAll();

        return products.stream()
                .map(product -> ProductResponse.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .description(product.getDescription())
                        .price(product.getPrice())
                        .quantity(product.getQuantity())
                        .imageUrl(product.getImageUrl())
                        .screenSize(product.getScreenSize())
                        .resolution(product.getResolution())
                        .refreshRate(product.getRefreshRate())
                        .smartFeatures(product.getSmartFeatures())
                        .build())
                .toList();
    }
    @Override
    public ProductResponse getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with ID " + id + " not found"));

        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .imageUrl(product.getImageUrl())
                .screenSize(product.getScreenSize())
                .resolution(product.getResolution())
                .refreshRate(product.getRefreshRate())
                .smartFeatures(product.getSmartFeatures())
                .build();
    }

    @Override
    public ProductResponse updateProduct(Long id, ProductRequest request) {
        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with ID " + id + " not found"));

        existing.setName(request.getName());
        existing.setDescription(request.getDescription());
        existing.setPrice(request.getPrice());
        existing.setQuantity(request.getQuantity());
        existing.setImageUrl(request.getImageUrl());
        existing.setScreenSize(request.getScreenSize());
        existing.setResolution(request.getResolution());
        existing.setRefreshRate(request.getRefreshRate());
        existing.setSmartFeatures(request.getSmartFeatures());

        Product updated = productRepository.save(existing);

        return ProductResponse.builder()
                .id(updated.getId())
                .name(updated.getName())
                .description(updated.getDescription())
                .price(updated.getPrice())
                .quantity(updated.getQuantity())
                .imageUrl(updated.getImageUrl())
                .screenSize(updated.getScreenSize())
                .resolution(updated.getResolution())
                .refreshRate(updated.getRefreshRate())
                .smartFeatures(updated.getSmartFeatures())
                .build();
    }
    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with ID " + id + " not found"));

        productRepository.delete(product);
    }


}
