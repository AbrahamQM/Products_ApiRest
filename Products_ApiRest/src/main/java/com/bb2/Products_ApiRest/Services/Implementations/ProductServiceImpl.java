package com.bb2.Products_ApiRest.Services.Implementations;

import com.bb2.Products_ApiRest.DTOs.ProductDTO;
import com.bb2.Products_ApiRest.Enums.StateEnum;
import com.bb2.Products_ApiRest.Mappers.ProductMapper;
import com.bb2.Products_ApiRest.Repositories.ProductRepository;
import com.bb2.Products_ApiRest.Services.Interfaces.ProductService;
import com.bb2.Products_ApiRest.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> pojos = productRepository.findAll();
        List<ProductDTO> dtos = new ArrayList<ProductDTO>();
        for (Product product : pojos) {
            dtos.add(productMapper.modelToDto(product));
        }
        return dtos;
    }

    @Override
    public void save(ProductDTO productDTO) {
        productRepository.save(productMapper.dtoToModel(productDTO));
    }

    @Override
    public ProductDTO getById(Long id) {
        return productMapper.modelToDto(productRepository.getById(id));
    }

    @Override
    public void deactivate(ProductDTO productDTO) {
        productDTO.setState(StateEnum.DISCONTINUED);
        save(productDTO);
    }
}
