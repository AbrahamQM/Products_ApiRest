package com.bb2.Products_ApiRest.Mappers.Impl;

import com.bb2.Products_ApiRest.DTOs.SupplierDTO;
import com.bb2.Products_ApiRest.Mappers.SupplierMapper;
import com.bb2.Products_ApiRest.models.Supplier;

import java.util.List;
//Todo todo, por ahora está implementado con intellij, falta implementar correctamente.

public class SupplierMapperImpl implements SupplierMapper {
    @Override
    public Supplier dtoToModel(SupplierDTO supplierDTO) {
        return null;
    }

    @Override
    public SupplierDTO ModelToDTO(Supplier supplier) {
        return null;
    }

    @Override
    public List<Supplier> getListModels(List<SupplierDTO> supplierDtoList) {
        return null;
    }

    @Override
    public List<SupplierDTO> getListDtos(List<Supplier> supplierList) {
        return null;
    }
}
