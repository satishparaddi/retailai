package com.retailai.productservice.controller;

import com.retailai.productservice.dto.ProductRequest;
import com.retailai.productservice.dto.ProductResponse;
import com.retailai.productservice.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody ProductRequest request) {
        ProductResponse response = productService.createProduct(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts(
            @RequestParam(required = false) String name) {
        return ResponseEntity.ok(productService.getAllProducts(name));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(
            @PathVariable Long id,
            @Valid @RequestBody ProductRequest request) {
        return ResponseEntity.ok(productService.updateProduct(id, request));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();  // 204 No Content
    }

}
