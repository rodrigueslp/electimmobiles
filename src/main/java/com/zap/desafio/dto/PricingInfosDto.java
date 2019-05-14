package com.zap.desafio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PricingInfosDto {

    private String yearlyIptu;

    private BigDecimal price;

    private BigDecimal rentalTotalPrice;

    private String businessType;

    private BigDecimal monthlyCondoFee;

}
