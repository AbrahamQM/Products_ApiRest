package com.bb2.Products_ApiRest.Services.Implementations;

import com.bb2.Products_ApiRest.DTOs.SupplierDTO;
import com.bb2.Products_ApiRest.Mappers.SupplierMapper;
import com.bb2.Products_ApiRest.Repositories.SupplierRepository;
import com.bb2.Products_ApiRest.Services.Interfaces.SupplierService;
import com.bb2.Products_ApiRest.models.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    @Autowired
    SupplierMapper supplierMapper;


    @Override
    public List<SupplierDTO> getAllSuppliers() {
        List<Supplier> pojos = supplierRepository.findAll();
        List<SupplierDTO> dtos = new ArrayList<SupplierDTO>();
        for (Supplier supplier : pojos) {
            dtos.add(supplierMapper.modelToDTO(supplier));
        }
        return dtos;
    }

    @Override
    public void save(SupplierDTO supplierDTO) {
        supplierRepository.save(supplierMapper.dtoToModel(supplierDTO));
    }

    @Override
    public SupplierDTO getById(Long id) {
        return supplierMapper.modelToDTO(supplierRepository.getById(id));
    }
}
