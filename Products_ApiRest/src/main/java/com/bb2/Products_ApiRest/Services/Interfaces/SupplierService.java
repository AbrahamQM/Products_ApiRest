package com.bb2.Products_ApiRest.Services.Interfaces;

import com.bb2.Products_ApiRest.DTOs.ProductDTO;
import com.bb2.Products_ApiRest.DTOs.SupplierDTO;

import java.util.List;

public interface SupplierService {
    List<SupplierDTO> getAllSuppliers();
    void save(SupplierDTO supplierDTO);
    SupplierDTO getById(Long id);
}
