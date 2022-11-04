package com.bb2.Products_ApiRest.Services.Implementations;

import com.bb2.Products_ApiRest.DTOs.ProductDTO;
import com.bb2.Products_ApiRest.DTOs.SupplierDTO;
import com.bb2.Products_ApiRest.Exception.ResourceNotFoundException;
import com.bb2.Products_ApiRest.Mappers.SupplierMapper;
import com.bb2.Products_ApiRest.Repositories.SupplierRepository;
import com.bb2.Products_ApiRest.Services.Interfaces.ProductService;
import com.bb2.Products_ApiRest.Services.Interfaces.SupplierService;
import com.bb2.Products_ApiRest.models.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private SupplierMapper supplierMapper;

    @Autowired
    private ProductService productService;


    @Override
    public List<SupplierDTO> getAllSuppliers() {
        return supplierMapper.getListDtos(supplierRepository.findAll());
    }

    @Override
    public SupplierDTO save(SupplierDTO supplierDTO) {
        return supplierMapper.modelToDTO(supplierRepository.save(supplierMapper.dtoToModel(supplierDTO)));
    }

    @Override
    public SupplierDTO getById(Long id) {
        Supplier supplier = supplierRepository.getById(id);
        if (supplier == null) {
            return null;
        }
        return supplierMapper.modelToDTO(supplier);
    }

    @Override
    public SupplierDTO deleteById(Long id) {
        Optional<Supplier> supplierOpt = supplierRepository.findById(id);
        if (supplierOpt.isPresent()) {
            supplierRepository.deleteById(id);
            return supplierMapper.modelToDTO(supplierOpt.get());
        }
        throw new ResourceNotFoundException("Supplier not found for id " + id);
    }

    /**
     * Método que sustituye todos los supplier de los productos que coincidan con el supplierDTO que le pasamos.
     * por un supplier ficticio
     * Implementado para poder eliminar suppliers que ya están en algún producto
    **/
    @Override
    public void cleanProducts(SupplierDTO supplierDTO) {
        List<ProductDTO> products = productService.getAllProducts();
        for(ProductDTO product : products){
            List<SupplierDTO> suppliersDtoList = product.getSuppliers();
            for(SupplierDTO supplier : suppliersDtoList){
                if (supplier.getIdSupplier() == supplierDTO.getIdSupplier()){
                    suppliersDtoList.add(this.getById(0L));
                    suppliersDtoList.remove(supplier);
                }
            }
            product.setSuppliers(suppliersDtoList);
            productService.save(product);
        }
    }
}
