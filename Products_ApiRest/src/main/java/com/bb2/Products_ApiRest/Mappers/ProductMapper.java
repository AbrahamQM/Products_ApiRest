package com.bb2.Products_ApiRest.Mappers;

import com.bb2.Products_ApiRest.DTOs.ProductDTO;
import com.bb2.Products_ApiRest.models.Product;
import org.mapstruct.*;

import java.text.ParseException;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    //Assemblers
    @Mapping(target = "creationDate", source = "productDTO.creationDate", dateFormat ="dd-MM-yyyy HH:mm:ss")
    Product dtoToModel(ProductDTO productDTO);

    @Mapping(target = "creationDate", source = "product.creationDate", dateFormat ="dd-MM-yyyy HH:mm:ss")
    ProductDTO modelToDto(Product product);

    //Listados
    List<ProductDTO> getListDTO(List<Product> productList);
    List<Product> getListModels(List<ProductDTO> productDtoList);

    //Update
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateModel(ProductDTO productDto, @MappingTarget Product product) throws ParseException;
}
