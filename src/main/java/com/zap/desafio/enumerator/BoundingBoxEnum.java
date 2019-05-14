package com.zap.desafio.enumerator;

import lombok.Getter;

@Getter
public enum BoundingBoxEnum {

    MINLON(-46.693419), MINLAT(-23.568704),
    MAXLON(-46.641146), MAXLAT(-23.546686);

    private double latLon;

    BoundingBoxEnum(double latLon) {
        this.latLon = latLon;
    }
}
