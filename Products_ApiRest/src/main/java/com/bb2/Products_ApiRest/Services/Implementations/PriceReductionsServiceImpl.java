package com.bb2.Products_ApiRest.Services.Implementations;

import com.bb2.Products_ApiRest.DTOs.PriceReductionDTO;
import com.bb2.Products_ApiRest.DTOs.SupplierDTO;
import com.bb2.Products_ApiRest.Mappers.PriceReductionMapper;
import com.bb2.Products_ApiRest.Repositories.PriceReductionRepository;
import com.bb2.Products_ApiRest.Services.Interfaces.PriceReductionService;
import com.bb2.Products_ApiRest.models.PriceReduction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PriceReductionsServiceImpl implements PriceReductionService {

    @Autowired
    private PriceReductionRepository priceReductionRepository;

    @Autowired
    private PriceReductionMapper priceReductionMapper;

    @Override
    public List<PriceReductionDTO> getAllPriceReductions() {
        return priceReductionMapper.getListDTO(priceReductionRepository.findAll());
    }

    @Override
    public PriceReductionDTO save(PriceReductionDTO priceReductionDTO) {
        return priceReductionMapper
                .modelToDto(priceReductionRepository
                .save(priceReductionMapper.dtoToModel(priceReductionDTO)));
    }

    @Override
    public PriceReductionDTO getById(Long id) {
        PriceReduction pojo = priceReductionRepository.getById(id);
        if (pojo == null) {
            return null;
        }
        return priceReductionMapper.modelToDto(pojo);
    }

    @Override
    public PriceReductionDTO deleteById(Long id) {
        return null;
    }

    @Override
    public void cleanProducts(SupplierDTO supplierDTO) {

    }
}
