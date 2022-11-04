package com.bb2.Products_ApiRest.Mappers.Impl;

import com.bb2.Products_ApiRest.DTOs.ProductDTO;
import com.bb2.Products_ApiRest.DTOs.SupplierDTO;
import com.bb2.Products_ApiRest.Mappers.PriceReductionMapper;
import com.bb2.Products_ApiRest.Mappers.ProductMapper;
import com.bb2.Products_ApiRest.Mappers.SupplierMapper;
import com.bb2.Products_ApiRest.Mappers.UserMapper;
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

        SupplierMapper supplierMapper = new SupplierMapperImpl();
        PriceReductionMapper priceReductionMapper = new PriceReductionMapperImpl();


        Product product = new Product();
        product.setIdProduct(productDTO.getIdProduct());
        product.setItemCode(productDTO.getItemCode());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setState(productDTO.getState());
        product.setReasonDeactivation(productDTO.getReasonDeactivation());
//        for(SupplierDTO supplierDto : productDTO.getSuppliers()) {
//            product.addSupplier(supplierMapper.dtoToModel(supplierDto));
//        }
        product.setSuppliers(supplierMapper.getListModels(productDTO.getSuppliers()));
        product.setPriceReductions(priceReductionMapper.getListModels(productDTO.getPriceReductions()));

        product.setCreationDate(productDTO.getCreationDate());


        return product;
    }

    @Override
    public ProductDTO modelToDto(Product product) {
        if(product == null){
            return null;
        }
        SupplierMapper supplierMapper = new SupplierMapperImpl();
        PriceReductionMapper priceReductionMapper = new PriceReductionMapperImpl();
        UserMapper userMapper = new UserMapperImpl();
        ProductDTO productDTO = new ProductDTO();

        productDTO.setIdProduct(product.getIdProduct());
        productDTO.setItemCode(product.getItemCode());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        productDTO.setState(product.getState());
        productDTO.setReasonDeactivation(product.getReasonDeactivation());
        productDTO.setSuppliers(supplierMapper.getListDtos(product.getSuppliers()));
        productDTO.setPriceReductions(priceReductionMapper.getListDTO(product.getPriceReductions()));
        productDTO.setCreationDate(product.getCreationDate());
        productDTO.setCreator(userMapper.modelToDto(product.getCreator()));

        return productDTO;
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
