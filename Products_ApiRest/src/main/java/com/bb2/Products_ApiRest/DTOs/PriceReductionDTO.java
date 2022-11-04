package com.bb2.Products_ApiRest.DTOs;

import java.time.LocalDate;

public class PriceReductionDTO {
    private Long idPriceReduction;

    private String description;
    private Double reducedPrice;
    private LocalDate startDate;
    private LocalDate endDate;

    public PriceReductionDTO() {
    }

    public PriceReductionDTO(Long idPriceReduction, String description, Double reducedPrice, LocalDate startDate, LocalDate endDate) {
        this.idPriceReduction = idPriceReduction;
        this.description = description;
        this.reducedPrice = reducedPrice;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getIdPriceReduction() {
        return idPriceReduction;
    }

    public void setIdPriceReduction(Long idPriceReduction) {
        this.idPriceReduction = idPriceReduction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getReducedPrice() {
        return reducedPrice;
    }

    public void setReducedPrice(Double reducedPrice) {
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
