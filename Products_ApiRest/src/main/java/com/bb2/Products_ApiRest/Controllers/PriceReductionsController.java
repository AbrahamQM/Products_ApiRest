package com.bb2.Products_ApiRest.Controllers;

import com.bb2.Products_ApiRest.DTOs.PriceReductionDTO;
import com.bb2.Products_ApiRest.Services.Interfaces.PriceReductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/priceReductions")
public class PriceReductionsController {

    @Autowired
    private PriceReductionService priceReductionService;

    @GetMapping("/allPriceReductions")
    public ResponseEntity<List<PriceReductionDTO>> getAllPriceReductions() {
        List<PriceReductionDTO> priceReductions = priceReductionService.getAllPriceReductions();
        if (priceReductions.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(priceReductions);
    }

    @GetMapping("/priceReductionById/{id}")
    public ResponseEntity<PriceReductionDTO> getPriceReductionById(@PathVariable Long id) {
        PriceReductionDTO dto = priceReductionService.getById(id);
        if (dto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/create")
    public ResponseEntity<PriceReductionDTO> createPriceReduction(@RequestBody PriceReductionDTO dto) {
        for (PriceReductionDTO priceReductionDTO : priceReductionService.getAllPriceReductions()){
            if (priceReductionDTO.getIdPriceReduction() == dto.getIdPriceReduction()){
                return ResponseEntity.status(HttpServletResponse.SC_CONFLICT).build();
            }
        }
        dto = priceReductionService.save(dto);
        return ResponseEntity.ok(dto);
    }
}
