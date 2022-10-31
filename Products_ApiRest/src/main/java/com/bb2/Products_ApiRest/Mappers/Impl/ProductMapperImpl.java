package com.bb2.Products_ApiRest.Mappers.Impl;

import com.bb2.Products_ApiRest.DTOs.ProductDTO;
import com.bb2.Products_ApiRest.DTOs.SupplierDTO;
import com.bb2.Products_ApiRest.Mappers.ProductMapper;
import com.bb2.Products_ApiRest.Mappers.SupplierMapper;
import com.bb2.Products_ApiRest.models.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.util.List;

public class ProductMapperImpl implements ProductMapper {
    @Override
    public Product dtoToModel(ProductDTO productDTO) {
        if(productDTO == null){
            return null;
        }

        @Autowired
        SupplierMapper supplierMapper;

        Product product = new Product();
        product.setIdProduct(productDTO.getIdProduct());
        product.setItemCode(productDTO.getItemCode());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setState(productDTO.getState());
        product.setReasonDeactivation(productDTO.getReasonDeactivation());

        for(SupplierDTO supplierDto : productDTO.getSuppliers()) {
            product.addSupplier(supplierMapper.dtoToModel(supplierDto));
        }

        product.setCreationDate(productDTO.getCreationDate());


        return null;
    }

    @Override
    public ProductDTO ModelToDTO(Product product) {
        return null;
    }

    @Override
    public List<ProductDTO> getListDTO(List<Product> productList) {
        return null;
    }

    @Override
    public List<Product> getListModels(List<ProductDTO> productDtoList) {
        return null;
    }

    @Override
    public void updateModel(ProductDTO productDto, Product product) throws ParseException {

    }
}
