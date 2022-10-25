package com.bb2.Products_ApiRest.Mappers;

import com.bb2.Products_ApiRest.DTOs.SupplierDTO;
import com.bb2.Products_ApiRest.models.Supplier;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SupplierMapper {

    //Assemblers
    Supplier dtoToModel(SupplierDTO supplierDTO);
    SupplierDTO ModelToDTO(Supplier supplier);

    //Listados
    List<Supplier> getListEntities(List<SupplierDTO> supplierDtoList);
    List<SupplierDTO> getListDtos(List<Supplier> supplierList);
}
