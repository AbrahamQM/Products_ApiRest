package com.bb2.Products_ApiRest.Services.Interfaces;

import com.bb2.Products_ApiRest.DTOs.PriceReductionDTO;
import com.bb2.Products_ApiRest.DTOs.SupplierDTO;

import java.util.List;

public interface PriceReductionService {
    List<PriceReductionDTO> getAllPriceReductions();
    PriceReductionDTO save(PriceReductionDTO priceReductionDTO);
    PriceReductionDTO getById(Long id);
    PriceReductionDTO deleteById(Long id);
    void cleanProducts(PriceReductionDTO priceReductionDTO);
}
