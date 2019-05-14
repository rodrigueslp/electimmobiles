package com.zap.desafio.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
public class ParameterDto {

    private BigDecimal price;

    private BigDecimal rentalPrice;

    private BigDecimal monthlyCondoFee;

    private BigDecimal usableAreas;

    private String businessType;

    private LocationDto locationDto;

    public ParameterDto() {
        price = BigDecimal.ZERO;
        rentalPrice = BigDecimal.ZERO;
        monthlyCondoFee = BigDecimal.ZERO;
        usableAreas = BigDecimal.ZERO;
        businessType = "";
        locationDto = new LocationDto(0, 0);
    }

}
