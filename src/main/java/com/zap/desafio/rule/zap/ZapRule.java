package com.zap.desafio.rule.zap;

import com.zap.desafio.rule.LatLongRule;
import com.zap.desafio.rule.RentalRule;
import com.zap.desafio.rule.SaleRule;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ZapRule implements RentalRule, SaleRule, LatLongRule {

    @Override
    public Boolean validRentalPrice(BigDecimal price, BigDecimal minPrice) {
        return price.longValue() >= minPrice.longValue();
    }

    @Override
    public Boolean validSalePrice(BigDecimal price, BigDecimal minPrice) {
        return price.longValue() >= minPrice.longValue();
    }

    @Override
    public Boolean validLatLong(double lat, double lon) {
        return lat != 0 && lon != 0;
    }

    public Boolean validUsableAreas(BigDecimal usableAreas) {
        return usableAreas.longValue() > BigDecimal.valueOf(3500).longValue();
    }

}
