package com.zap.desafio.dto;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class BoundingBoxDto {

    private final double minLongitude;
    private final double minLatitude;
    private final double maxLongitude;
    private final double maxLatitude;

    public BoundingBoxDto(double minLongitude, double minLatitude, double maxLongitude, double maxLatitude) {
        this.minLongitude = minLongitude;
        this.minLatitude = minLatitude;
        this.maxLongitude = maxLongitude;
        this.maxLatitude = maxLatitude;
    }
}
