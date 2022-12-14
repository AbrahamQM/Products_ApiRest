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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class ProductDTO {

    private Long idProduct;
    private Long itemCode;//  Item code: Must be a unique value. This should be a numeric value.
    private String description;
    private Double price;
    private StateEnum state;//  State : This can either be ‘Active’ or ‘Discontinued’.
    private String reasonDeactivation;
    private List<SupplierDTO> suppliers = new ArrayList<>();
    private List<PriceReductionDTO> priceReductions = new ArrayList<>();
    private LocalDateTime creationDate;
    private UserDTO creator;

    //constructores
    public ProductDTO() {
    }

    public ProductDTO(Long idProduct,
                      Long itemCode,
                      String description,
                      Double price,
                      StateEnum state,
                      String reasonDeactivation,
                      List<SupplierDTO> suppliers,
                      List<PriceReductionDTO> priceReductions,
                      LocalDateTime creationDate,
                      UserDTO creator) {
        this.idProduct = idProduct;
        this.itemCode = itemCode;
        this.description = description;
        this.price = price;
        this.state = state;
        this.reasonDeactivation = reasonDeactivation;
        this.suppliers = suppliers;
        this.priceReductions = priceReductions;
        this.creationDate = creationDate;
        this.creator = creator;
    }

    //getter & Setter


    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public Long getItemCode() {
        return itemCode;
    }

    public void setItemCode(Long itemCode) {
        this.itemCode = itemCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public StateEnum getState() {
        return state;
    }

    public void setState(StateEnum state) {
        this.state = state;
    }

    public String getReasonDeactivation() {
        return reasonDeactivation;
    }

    public void setReasonDeactivation(String reasonDeactivation) {
        this.reasonDeactivation = reasonDeactivation;
    }

    public List<SupplierDTO> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<SupplierDTO> suppliers) {
        this.suppliers = suppliers;
    }

    //Método para añadir un supplier a la lista
    public void addSupplier(SupplierDTO supplierDto){
        this.suppliers.add(supplierDto);
    }

    public List<PriceReductionDTO> getPriceReductions() {
        return priceReductions;
    }

    public void setPriceReductions(List<PriceReductionDTO> priceReductions) {
        this.priceReductions = priceReductions;
    }

    //Método para añadir un priceReduction a la lista
    public void addPriceReduction(PriceReductionDTO priceReductionDto){ this.priceReductions.add(priceReductionDto);}

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public UserDTO getCreator() {
        return creator;
    }

    public void setCreator(UserDTO creator) {
        this.creator = creator;
    }
}
