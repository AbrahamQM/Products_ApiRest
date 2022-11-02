package com.bb2.Products_ApiRest.Mappers;

import com.bb2.Products_ApiRest.DTOs.PriceReductionDTO;
import com.bb2.Products_ApiRest.models.PriceReduction;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PriceReductionMapper {
    //Assembler
    @Mapping(target = "startDate", source = "priceReductionDTO.startDate", dateFormat = "dd-MM-yyyy")
    @Mapping(target = "endDate", source = "priceReductionDTO.endDate", dateFormat ="dd-MM-yyyy")
    PriceReduction dtoToModel(PriceReductionDTO priceReductionDTO);

    @Mapping(target = "startDate", source = "priceReduction.startDate", dateFormat = "dd-MM-yyyy")
    @Mapping(target = "endDate", source = "priceReduction.endDate", dateFormat ="dd-MM-yyyy")
    PriceReductionDTO modelToDto(PriceReduction priceReduction);


    //Listados
    List<PriceReduction> getListModels(List<PriceReductionDTO> priceReductionDTOList);
    List<PriceReductionDTO> getListDTO(List<PriceReduction> priceReductionList);

    //Update
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateModel(PriceReductionDTO priceReductionDTO, @MappingTarget PriceReduction priceReduction);
}
