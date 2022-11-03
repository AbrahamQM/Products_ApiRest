package com.bb2.Products_ApiRest.Controllers;


import com.bb2.Products_ApiRest.DTOs.ProductDTO;
import com.bb2.Products_ApiRest.DTOs.SupplierDTO;
import com.bb2.Products_ApiRest.Services.Interfaces.ProductService;
import com.bb2.Products_ApiRest.Services.Interfaces.SupplierService;
import com.bb2.Products_ApiRest.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/suppliers")
public class SuppliersController {

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private ProductService productService;

    @GetMapping("/allSuppliers")
    public ResponseEntity<List<SupplierDTO>> getAllSuppliers() {
        List<SupplierDTO> suppliers = supplierService.getAllSuppliers();
        if(suppliers.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(suppliers);
    }

    @GetMapping("/supplierById/{id}")
    public ResponseEntity<SupplierDTO> getSupplierById(@PathVariable Long id) {
        SupplierDTO dto = supplierService.getById(id);
        if(dto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/create")
    public ResponseEntity<SupplierDTO> create(@RequestBody SupplierDTO dto){
        for (SupplierDTO supplierDTO : supplierService.getAllSuppliers()){
            if(dto.getName().equalsIgnoreCase(supplierDTO.getName())){
                return ResponseEntity.status(HttpServletResponse.SC_CONFLICT).build();
            }
        }
        dto = supplierService.save(dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/delete/{id}") //Todo, bug al intentar eliminar elemento que ya no existe
    public ResponseEntity<SupplierDTO> delete(@PathVariable Long id) {
        if (id == null) {
            System.out.println("Trying to delete by id without id parameter");
            return ResponseEntity.badRequest().build();
        }
        SupplierDTO dto = supplierService.getById(id);
        if (dto == null) {
            System.out.println("Trying to delete an non-existent Supplier ");
        }
        //sustituyo el supplier en todos los productos que contengan este supplier en su lista a supplier ficticio
        supplierService.cleanProducts(dto);

        supplierService.deleteById(id);
        return ResponseEntity.ok(dto);
    }

}
