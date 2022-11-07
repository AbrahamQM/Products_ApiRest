package com.bb2.Products_ApiRest.Services.Implementations;

import com.bb2.Products_ApiRest.DTOs.PriceReductionDTO;
import com.bb2.Products_ApiRest.DTOs.ProductDTO;
import com.bb2.Products_ApiRest.Exception.ResourceNotFoundException;
import com.bb2.Products_ApiRest.Mappers.PriceReductionMapper;
import com.bb2.Products_ApiRest.Repositories.PriceReductionRepository;
import com.bb2.Products_ApiRest.Services.Interfaces.PriceReductionService;
import com.bb2.Products_ApiRest.Services.Interfaces.ProductService;
import com.bb2.Products_ApiRest.models.PriceReduction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PriceReductionsServiceImpl implements PriceReductionService {

    @Autowired
    private PriceReductionRepository priceReductionRepository;

    @Autowired
    private PriceReductionMapper priceReductionMapper;

    @Autowired
    private ProductService productService;

    @Override
    public List<PriceReductionDTO> getAllPriceReductions() {
        return priceReductionMapper.getListDTO(priceReductionRepository.findAll());
    }

    @Override
    public PriceReductionDTO save(PriceReductionDTO priceReductionDTO) {
        return priceReductionMapper
                .modelToDto(priceReductionRepository
                .save(priceReductionMapper.dtoToModel(priceReductionDTO)));
    }

    @Override
    public PriceReductionDTO getById(Long id) {
        PriceReduction pojo = priceReductionRepository.getById(id);
        if (pojo == null) {
            return null;
        }
        return priceReductionMapper.modelToDto(pojo);
    }

    @Override
    public PriceReductionDTO deleteById(Long id) {
        Optional<PriceReduction> priceReductionOpt = priceReductionRepository.findById(id);
        if (priceReductionOpt.isPresent()) {
            priceReductionRepository.deleteById(id);
            return priceReductionMapper.modelToDto(priceReductionOpt.get());
        }
        throw new ResourceNotFoundException("Price Reduction not found for id " + id);
    }

    /**
     * Método que sustituye el descuento de cada producto por un descuento ficticio
     *
    **/
    @Override
    public void cleanProducts(PriceReductionDTO priceReductionDTO) {
        List<ProductDTO> products = productService.getAllProducts();
        for (ProductDTO productDTO : products) {
            List<PriceReductionDTO> priceReductionDTOList = productDTO.getPriceReductions();
            for (PriceReductionDTO reductionDTO : priceReductionDTOList){
                if (reductionDTO.getIdPriceReduction() == priceReductionDTO.getIdPriceReduction()){
                    priceReductionDTOList.add(this.getById(0L));
                    priceReductionDTOList.remove(reductionDTO);
                }
            }
            productDTO.setPriceReductions(priceReductionDTOList);
            productService.save(productDTO);
        }
    }
}
