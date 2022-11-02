package com.bb2.Products_ApiRest.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class SupplierDTO {
    private Long idSupplier;
    private String name;
    private String country;

    //Constructores

    public SupplierDTO() {
    }

    public SupplierDTO(Long idSupplier, String name, String country) {
        this.idSupplier = idSupplier;
        this.name = name;
        this.country = country;
    }

    //Getter y setters

    public Long getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(Long idSupplier) {
        this.idSupplier = idSupplier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
