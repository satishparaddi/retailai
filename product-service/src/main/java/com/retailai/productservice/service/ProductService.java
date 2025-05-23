package com.retailai.productservice.service;

import com.retailai.productservice.dto.ProductRequest;
import com.retailai.productservice.dto.ProductResponse;
import java.util.List;
public interface ProductService {
    ProductResponse createProduct(ProductRequest request);
    List<ProductResponse> getAllProducts(String name);
    ProductResponse getProductById(Long id);
    ProductResponse updateProduct(Long id, ProductRequest request);
    void deleteProduct(Long id);


}
