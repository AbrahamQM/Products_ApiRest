package com.bb2.Products_ApiRest.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PriceReductionDTO {
    private Long idPriceReduction;
    private Long reducedPrice;
    private LocalDate startDate;
    private LocalDate endDate;
}
