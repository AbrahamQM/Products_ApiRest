package com.bb2.Products_ApiRest.Services.Interfaces;

import com.bb2.Products_ApiRest.DTOs.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProducts();
    void save(ProductDTO user);
    ProductDTO getById(Long id);
    void deactivate(ProductDTO productDTO);
}
