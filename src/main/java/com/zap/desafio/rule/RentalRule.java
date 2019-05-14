package com.zap.desafio.rule;

import java.math.BigDecimal;

public interface RentalRule {

    Boolean validRentalPrice(BigDecimal price, BigDecimal maximumPrice);

}
