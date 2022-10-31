package com.bb2.Products_ApiRest.Controllers;

import com.bb2.Products_ApiRest.DTOs.ProductDTO;
import com.bb2.Products_ApiRest.DTOs.UserDTO;
import com.bb2.Products_ApiRest.Services.Interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductService productService;


    @GetMapping("/allProducts")
    public List<ProductDTO> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/productDetails")
    public ResponseEntity<ProductDTO> getProductDetails(@RequestBody ProductDTO productDTO){
        return ResponseEntity.ok(productService.getById(productDTO.getIdProduct()));
    }


    @PostMapping("/create")
    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO productDTO ) {
        if (productDTO.getItemCode() == null || productDTO.getDescription() == null) {
            return ResponseEntity.badRequest().build();
        }
        productService.save(productDTO);
        return ResponseEntity.ok(productDTO);
    }

    @PutMapping("/update")
    public ResponseEntity<ProductDTO> update(@RequestBody ProductDTO productDTO) {
        if (productService.getById(productDTO.getIdProduct()) == null){
            return ResponseEntity.notFound().build(); //si no existe el producto, devuelvo 404
        }
        productService.save(productDTO);
        return ResponseEntity.ok(productDTO);
    }

    @PutMapping("/deactivate")
    public ResponseEntity<ProductDTO> deactivate(@RequestBody ProductDTO productDTO) {
        if (productService.getById(productDTO.getIdProduct()) == null){
            return ResponseEntity.notFound().build(); //si no existe el producto, devuelvo 404
        }
        productService.deactivate(productDTO);
        return ResponseEntity.ok(productDTO);
    }
}
