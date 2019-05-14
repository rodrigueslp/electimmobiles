package com.zap.desafio.business;

import com.zap.desafio.dto.BoundingBoxDto;
import com.zap.desafio.dto.ImmobileDto;
import com.zap.desafio.dto.ParameterDto;
import com.zap.desafio.enumerator.BoundingBoxEnum;
import com.zap.desafio.enumerator.BusinessTypeEnum;
import com.zap.desafio.rule.vivareal.VivaRealRule;
import com.zap.desafio.rule.zap.ZapRule;
import com.zap.desafio.provider.ImmobileProvider;
import com.zap.desafio.util.BoundingBoxUtil;
import com.zap.desafio.util.ValidateParameterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ElectImmobileBusiness {

    private final BigDecimal MAXIMUM_PRICE_RENTAL_VIVAREAL = new BigDecimal(4000);
    private final BigDecimal MAXIMUM_PRICE_SALE_VIVAREAL = new BigDecimal(700000);
    private final BigDecimal MIN_PRICE_RENTAL_ZAP = new BigDecimal(3500);
    private final BigDecimal MIN_PRICE_SALE_ZAP = new BigDecimal(600000);

    @Autowired
    private VivaRealRule vivaRealRule;

    @Autowired
    private ZapRule zapRule;

    @Autowired
    private ImmobileProvider immobileProvider;

    public void electToVivaReal(ImmobileDto immobileDto) {

        ParameterDto parameterDto = ValidateParameterUtil.getImmobileValidateParameter(immobileDto);

        if (BusinessTypeEnum.RENTAL.getBusinessType().equals(parameterDto.getBusinessType())) {

            boolean boundingBoxContains = BoundingBoxUtil.contains(parameterDto.getLocationDto().getLat(), parameterDto.getLocationDto().getLon());

            if (boundingBoxContains) {
                BigDecimal newMaximumPriceRentalVivaReal =
                        new BigDecimal(MAXIMUM_PRICE_RENTAL_VIVAREAL.doubleValue() + (MAXIMUM_PRICE_RENTAL_VIVAREAL.doubleValue() / 2));
                if (!vivaRealRule.validRentalPrice(parameterDto.getRentalPrice(), newMaximumPriceRentalVivaReal)) return;
            } else {
                if (!vivaRealRule.validRentalPrice(parameterDto.getRentalPrice(), MAXIMUM_PRICE_RENTAL_VIVAREAL)) return;
            }

            if (!vivaRealRule.validLimitCondominiumValue(parameterDto.getRentalPrice(), parameterDto.getMonthlyCondoFee())) return;

        } else if (BusinessTypeEnum.SALE.getBusinessType().equals(parameterDto.getBusinessType())) {

            if (!vivaRealRule.validSalePrice(parameterDto.getPrice(), MAXIMUM_PRICE_SALE_VIVAREAL)) return;

        } else return;

        if (!vivaRealRule.validLatLong(parameterDto.getLocationDto().getLat(), parameterDto.getLocationDto().getLon())) return;

        immobileProvider.addImmobileVivaReal(immobileDto);

    }

    public void electToZap(ImmobileDto immobileDto) {

        ParameterDto parameterDto = ValidateParameterUtil.getImmobileValidateParameter(immobileDto);

        if (BusinessTypeEnum.RENTAL.getBusinessType().equals(parameterDto.getBusinessType())) {

            if (!zapRule.validRentalPrice(parameterDto.getRentalPrice(), MIN_PRICE_RENTAL_ZAP)) return;
            if (!zapRule.validUsableAreas(parameterDto.getUsableAreas())) return;

        } else if (BusinessTypeEnum.SALE.getBusinessType().equals(parameterDto.getBusinessType())) {

            boolean boundingBoxContains = BoundingBoxUtil.contains(parameterDto.getLocationDto().getLat(), parameterDto.getLocationDto().getLon());

            if (boundingBoxContains) {
                BigDecimal newMinPriceSaleZap = new BigDecimal(MIN_PRICE_SALE_ZAP.doubleValue() - (10.0 / 100.0) * MIN_PRICE_SALE_ZAP.doubleValue());
                if (!zapRule.validSalePrice(parameterDto.getPrice(), newMinPriceSaleZap)) return;
            } else {
                if (!zapRule.validSalePrice(parameterDto.getPrice(), MIN_PRICE_SALE_ZAP)) return;
            }

        } else return;

        if (!zapRule.validLatLong(parameterDto.getLocationDto().getLat(), parameterDto.getLocationDto().getLon())) return;

        immobileProvider.addImmobileZap(immobileDto);

    }

}
