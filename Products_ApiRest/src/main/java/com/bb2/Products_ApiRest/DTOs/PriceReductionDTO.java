package com.bb2.Products_ApiRest.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

//
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class PriceReductionDTO {
    private Long idPriceReduction;
    private Long reducedPrice;
    private LocalDate startDate;
    private LocalDate endDate;

    //Constructores
    public PriceReductionDTO() {
    }

    public PriceReductionDTO(Long idPriceReduction, Long reducedPrice, LocalDate startDate, LocalDate endDate) {
        this.idPriceReduction = idPriceReduction;
        this.reducedPrice = reducedPrice;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    //Getter y setters

    public Long getIdPriceReduction() {
        return idPriceReduction;
    }

    public void setIdPriceReduction(Long idPriceReduction) {
        this.idPriceReduction = idPriceReduction;
    }

    public Long getReducedPrice() {
        return reducedPrice;
    }

    public void setReducedPrice(Long reducedPrice) {
        this.reducedPrice = reducedPrice;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
