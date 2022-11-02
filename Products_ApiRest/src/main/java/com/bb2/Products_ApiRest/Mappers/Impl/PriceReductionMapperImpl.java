package com.bb2.Products_ApiRest.Mappers.Impl;

import com.bb2.Products_ApiRest.DTOs.PriceReductionDTO;
import com.bb2.Products_ApiRest.Mappers.PriceReductionMapper;
import com.bb2.Products_ApiRest.models.PriceReduction;

import java.util.ArrayList;
import java.util.List;

public class PriceReductionMapperImpl implements PriceReductionMapper {
    @Override
    public PriceReduction dtoToModel(PriceReductionDTO priceReductionDTO) {
        if (priceReductionDTO == null){
            return null;
        }
        PriceReduction priceReduction = new PriceReduction();

        priceReduction.setIdPriceReduction(priceReductionDTO.getIdPriceReduction());
        priceReduction.setReducedPrice(priceReductionDTO.getReducedPrice());
        priceReduction.setStartDate(priceReductionDTO.getStartDate());
        priceReduction.setEndDate(priceReductionDTO.getEndDate());
        return priceReduction;
    }

    @Override
    public PriceReductionDTO modelToDto(PriceReduction priceReduction) {
        if (priceReduction == null){
            return null;
        }
        PriceReductionDTO priceReductionDTO = new PriceReductionDTO();
        priceReductionDTO.setIdPriceReduction(priceReduction.getIdPriceReduction());
        priceReductionDTO.setReducedPrice(priceReduction.getReducedPrice());
        priceReductionDTO.setStartDate(priceReduction.getStartDate());
        priceReductionDTO.setEndDate(priceReduction.getEndDate());
        return priceReductionDTO;
    }

    @Override
    public List<PriceReduction> getListModels(List<PriceReductionDTO> priceReductionDTOList) {
        if (priceReductionDTOList == null){
            return null;
        }
        List<PriceReduction> priceReductionList = new ArrayList<PriceReduction>();

        for (PriceReductionDTO priceReductionDTO : priceReductionDTOList){
            priceReductionList.add(dtoToModel(priceReductionDTO));
        }
        return priceReductionList;
    }

    @Override
    public List<PriceReductionDTO> getListDTO(List<PriceReduction> priceReductionList) {
        if (priceReductionList == null){
            return null;
        }
        List<PriceReductionDTO> priceReductionDTOList = new ArrayList<PriceReductionDTO>();

        for (PriceReduction priceReduction : priceReductionList){
            priceReductionDTOList.add(modelToDto(priceReduction));
        }
        return priceReductionDTOList;
    }

    @Override
    public void updateModel(PriceReductionDTO priceReductionDTO, PriceReduction priceReduction) {

    }
}
