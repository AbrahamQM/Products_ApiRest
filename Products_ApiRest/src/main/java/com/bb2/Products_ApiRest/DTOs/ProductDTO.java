package com.bb2.Products_ApiRest.DTOs;

import com.bb2.Products_ApiRest.Enums.StateEnum;
import com.bb2.Products_ApiRest.models.PriceReduction;
import com.bb2.Products_ApiRest.models.Supplier;
import com.bb2.Products_ApiRest.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Long idProduct;
    private Long itemCode;//  Item code: Must be a unique value. This should be a numeric value.
    private String description;
    private Double price;
    private StateEnum state;//  State : This can either be ‘Active’ or ‘Discontinued’.
    private String reasonDeactivation;
    private Set<SupplierDTO> suppliers = new HashSet();
    private Set<PriceReductionDTO> priceReductions = new HashSet();
    private LocalDateTime creationDate;
    private UserDTO creator;
}
