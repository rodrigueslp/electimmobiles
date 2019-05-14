package com.zap.desafio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImmobileDto {

    private BigDecimal usableAreas;

    private String listingType;

    private String listingStatus;

    private String id;

    private int parkingSpaces;

    private LocalDate createdAt;

    private LocalDate updatedAt;

    private Boolean owner;

    private String[] images;

    private int bathrooms;

    private int bedrooms;

    private AddressDto address;

    private PricingInfosDto pricingInfos;

}
