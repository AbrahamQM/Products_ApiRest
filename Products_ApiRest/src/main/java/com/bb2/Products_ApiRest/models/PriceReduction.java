package com.bb2.Products_ApiRest.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "PriceReductions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PriceReduction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pricereductions_id_seq")
    @SequenceGenerator(name = "pricereductions_id_seq", sequenceName = "pricereductions_id_seq", allocationSize = 1, schema = "erp")
    @Column(name = "priceReduction_id")
    private Long idPriceReduction;

    private Long reducedPrice;
    private LocalDate startDate;
    private LocalDate endDate;

}
