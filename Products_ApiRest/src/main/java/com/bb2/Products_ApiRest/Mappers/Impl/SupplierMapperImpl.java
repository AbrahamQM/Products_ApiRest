package com.bb2.Products_ApiRest.Mappers.Impl;

import com.bb2.Products_ApiRest.DTOs.SupplierDTO;
import com.bb2.Products_ApiRest.Mappers.SupplierMapper;
import com.bb2.Products_ApiRest.models.Supplier;

import java.util.ArrayList;
import java.util.List;
//Todo todo, por ahora está implementado con intellij, falta implementar correctamente.

public class SupplierMapperImpl implements SupplierMapper {
    @Override
    public Supplier dtoToModel(SupplierDTO supplierDTO) {
        if (supplierDTO == null) {
            return null;
        }
        Supplier supplier = new Supplier();
        supplier.setIdSupplier(supplierDTO.getIdSupplier());
        supplier.setName(supplierDTO.getName());
        supplier.setCountry(supplierDTO.getCountry());
        return supplier;
    }

    @Override
    public SupplierDTO ModelToDTO(Supplier supplier) {
        if (supplier == null) {
            return null;
        }
        SupplierDTO supplierDTO = new SupplierDTO();
        supplierDTO.setIdSupplier(supplier.getIdSupplier());
        supplierDTO.setName(supplier.getName());
        supplierDTO.setCountry(supplier.getCountry());
        return supplierDTO;
    }

    @Override
    public List<Supplier> getListModels(List<SupplierDTO> supplierDtoList) {
        if(supplierDtoList == null){
            return null;
        }
        List<Supplier> suppliers = new ArrayList();
        for (SupplierDTO supplierDTO : supplierDtoList) {
            suppliers.add(dtoToModel(supplierDTO));
        }
        return suppliers;
    }

    @Override
    public List<SupplierDTO> getListDtos(List<Supplier> supplierList) {
        if(supplierList == null){
            return null;
        }
        List<SupplierDTO> suppliersDto = new ArrayList();
        for (Supplier supplier : supplierList) {
            suppliersDto.add(ModelToDTO(supplier));
        }
        return suppliersDto;
    }
}
