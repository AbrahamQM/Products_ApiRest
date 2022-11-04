package com.bb2.Products_ApiRest.Controllers;

import com.bb2.Products_ApiRest.DTOs.ProductDTO;
import com.bb2.Products_ApiRest.DTOs.SupplierDTO;
import com.bb2.Products_ApiRest.DTOs.UserDTO;
import com.bb2.Products_ApiRest.Services.Implementations.UserServiceImpl;
import com.bb2.Products_ApiRest.Services.Interfaces.ProductService;
import com.bb2.Products_ApiRest.Services.Interfaces.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private SupplierService supplierService;


    @GetMapping("/allProducts")
    public List<ProductDTO> getAllProducts(){
        List<ProductDTO> productsDtoList = productService.getAllProducts();
        for (ProductDTO productDto : productsDtoList){ // contraseñas a null para no mostrarlas
            UserDTO creator = productDto.getCreator();
            creator.setPassword(null);
            productDto.setCreator(creator);
        }
        return productsDtoList;
    }

    @GetMapping("/productDetails/{id}")
    public ResponseEntity<ProductDTO> getProductDetails(@PathVariable Long id){
        ProductDTO productDTO =productService.getById(id);
        if(id == null){
            return ResponseEntity.badRequest().build();
        }
        UserDTO creator = productDTO.getCreator();
        creator.setPassword(null);
        productDTO.setCreator(creator);
        return  ResponseEntity.ok(productDTO);
    }


    @PostMapping("/create/{creator_id}/{supplier_id}")
    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO productDto,
                                             @PathVariable Long creator_id ,
                                             @PathVariable Long supplier_id) {
        if (productDto.getItemCode() == null || productDto.getDescription() == null ||
                creator_id.equals(null) || supplier_id.equals(null)) {
            return ResponseEntity.badRequest().build();
        }
        try {
            UserDTO creator = userServiceImpl.getById(creator_id);
            SupplierDTO supplier = supplierService.getById(supplier_id);

            productDto.setCreator(creator);
            productDto.addSupplier(supplier);
            productService.save(productDto);
            //Oculto la password y devuelvo el producto:
            creator.setPassword(null);
            productDto.setCreator(creator);
            return ResponseEntity.ok(productDto);

        } catch (Exception e) {
            System.out.println("Trying to create a product with not-existing creator and/or supplier.");
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        if (productService.getById(id) == null){
            return ResponseEntity.notFound().build(); //si no existe el producto, devuelvo 404
        }
        ProductDTO oldProductDTO = productService.getById(id);
        productDTO.setIdProduct(id);
        productDTO.setCreator(oldProductDTO.getCreator());
        productService.save(productDTO); //Actualizo el producto
        //Oculto la password y devuelvo el producto:
        UserDTO creator = productDTO.getCreator();
        creator.setPassword(null);
        productDTO.setCreator(creator);
        return ResponseEntity.ok(productDTO);
    }

    @PutMapping("/deactivate/{id}")
    public ResponseEntity<ProductDTO> deactivate(@PathVariable Long id, @RequestBody String reasonDeactivation) {
        if (id == null || productService.getById(id) == null || reasonDeactivation == null){
            //si no pasan una id o, no existe el producto o, no incluyen la razón de desactivación , devuelvo 400
            return ResponseEntity.badRequest().build();
        }
        ProductDTO productDTO = productService.getById(id);
        productDTO.setReasonDeactivation(reasonDeactivation);
        productService.deactivate(productDTO);
        //Oculto la password y devuelvo el producto:
        UserDTO creator = productDTO.getCreator();
        creator.setPassword(null);
        productDTO.setCreator(creator);
        return ResponseEntity.ok(productDTO);
    }


    @PutMapping("/addSupplier/{product_id}/{supplier_id}")
    public ResponseEntity<ProductDTO> addSupplier(@PathVariable Long product_id, @PathVariable Long supplier_id){
        if (product_id.equals(null) || supplier_id.equals(null)){
            return ResponseEntity.badRequest().build();
        }
        ProductDTO productDto = productService.getById(product_id);
        SupplierDTO supplierDto = supplierService.getById(supplier_id);
        if (productDto == null || supplierDto == null) {
            return ResponseEntity.notFound().build();
        }
        productDto.addSupplier(supplierDto);
        productService.save(productDto);
        //Oculto la password y devuelvo el producto:
        UserDTO creator = productDto.getCreator();
        creator.setPassword(null);
        productDto.setCreator(creator);
        return ResponseEntity.ok(productDto);
    }
}
