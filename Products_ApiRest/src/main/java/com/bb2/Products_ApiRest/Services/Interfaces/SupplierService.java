package com.bb2.Products_ApiRest.Services.Interfaces;

import com.bb2.Products_ApiRest.DTOs.SupplierDTO;

import java.util.List;

public interface SupplierService {
    List<SupplierDTO> getAllSuppliers();
    SupplierDTO save(SupplierDTO supplierDTO);
    SupplierDTO getById(Long id);
    SupplierDTO deleteById(Long id);
    void cleanProducts(SupplierDTO supplierDTO);
}
