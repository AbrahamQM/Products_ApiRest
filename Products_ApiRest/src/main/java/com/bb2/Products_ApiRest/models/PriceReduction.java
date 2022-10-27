package com.bb2.Products_ApiRest.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name = "PriceReductions")
public class PriceReduction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pricereductions_id_seq")
    @SequenceGenerator(name = "pricereductions_id_seq", sequenceName = "pricereductions_id_seq", allocationSize = 1, schema = "erp")
    @Column(name = "priceReduction_id")
    private Long idPriceReduction;

    private Long reducedPrice;
    private LocalDate startDate;
    private LocalDate endDate;

    public PriceReduction() {
    }

    public PriceReduction(Long idPriceReduction, Long reducedPrice, LocalDate startDate, LocalDate endDate) {
        this.idPriceReduction = idPriceReduction;
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
