package com.zap.desafio.rule;

import java.math.BigDecimal;

public interface SaleRule {

    Boolean validSalePrice(BigDecimal price, BigDecimal maximumPrice);

}
