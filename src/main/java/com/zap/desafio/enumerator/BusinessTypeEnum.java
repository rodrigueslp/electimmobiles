package com.zap.desafio.enumerator;

import lombok.Getter;

@Getter
public enum BusinessTypeEnum {

    RENTAL("RENTAL"), SALE("SALE");

    private final String businessType;

    BusinessTypeEnum(String businessType) {
        this.businessType = businessType;
    }

}
