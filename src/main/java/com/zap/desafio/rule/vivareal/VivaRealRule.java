package com.zap.desafio.rule.vivareal;

import com.zap.desafio.rule.LatLongRule;
import com.zap.desafio.rule.RentalRule;
import com.zap.desafio.rule.SaleRule;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class VivaRealRule implements RentalRule, SaleRule, LatLongRule {

    @Override
    public Boolean validRentalPrice(BigDecimal price, BigDecimal maximumPrice) {
        return price.longValue() >= BigDecimal.ZERO.longValue() && price.longValue() <= maximumPrice.longValue();
    }

    @Override
    public Boolean validSalePrice(BigDecimal price, BigDecimal maximumPrice) {
        return price.longValue() >= BigDecimal.ZERO.longValue() && price.longValue() <= maximumPrice.longValue();
    }

    @Override
    public Boolean validLatLong(double lat, double lon) {
        return lat != 0
                && lon != 0;
    }

    public Boolean validLimitCondominiumValue(BigDecimal price, BigDecimal monthlyCondoFee) {
        if (price.equals(BigDecimal.ZERO)) return true;
        double percentual = 30.0 / 100.0;
        BigDecimal percentPrice = new BigDecimal(price.doubleValue() * percentual);
        return monthlyCondoFee.longValue() < percentPrice.longValue();
    }

}
