package com.zap.desafio.util;

import com.zap.desafio.dto.ImmobileDto;
import com.zap.desafio.dto.ParameterDto;

import java.math.BigDecimal;
import java.util.Objects;

public class ValidateParameterUtil {

    public static ParameterDto getImmobileValidateParameter(ImmobileDto immobileDto) {

        ParameterDto parameterDto = new ParameterDto();

        if (Objects.isNull(immobileDto)) return parameterDto;

        if (Objects.nonNull(immobileDto.getPricingInfos())) {

            if (Objects.nonNull(immobileDto.getPricingInfos().getPrice())) {
                parameterDto.setPrice(immobileDto.getPricingInfos().getPrice());
            } else {
                parameterDto.setPrice(BigDecimal.ZERO);
            }

            if (Objects.nonNull(immobileDto.getPricingInfos().getRentalTotalPrice())) {
                parameterDto.setRentalPrice(immobileDto.getPricingInfos().getRentalTotalPrice());
            } else {
                parameterDto.setRentalPrice(BigDecimal.ZERO);
            }

            if (Objects.nonNull(immobileDto.getPricingInfos().getMonthlyCondoFee())) {
                parameterDto.setMonthlyCondoFee(immobileDto.getPricingInfos().getMonthlyCondoFee());
            } else {
                parameterDto.setMonthlyCondoFee(BigDecimal.ZERO);
            }

            if (Objects.nonNull(immobileDto.getUsableAreas())) {
                parameterDto.setUsableAreas(immobileDto.getUsableAreas());
            } else {
                parameterDto.setUsableAreas(BigDecimal.ZERO);
            }

            if (Objects.nonNull(immobileDto.getPricingInfos().getBusinessType())) {
                parameterDto.setBusinessType(immobileDto.getPricingInfos().getBusinessType());
            }

        }

        if (Objects.nonNull(immobileDto.getAddress())
                && Objects.nonNull(immobileDto.getAddress().getGeoLocation())
                && Objects.nonNull(immobileDto.getAddress().getGeoLocation().getLocation())) {

            parameterDto.setLocationDto(immobileDto.getAddress().getGeoLocation().getLocation());

        }

        return parameterDto;

    }

}
