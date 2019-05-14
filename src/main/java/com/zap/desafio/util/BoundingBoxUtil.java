package com.zap.desafio.util;

import com.zap.desafio.dto.BoundingBoxDto;
import com.zap.desafio.enumerator.BoundingBoxEnum;

public class BoundingBoxUtil {


    public static boolean contains(double latitude, double longitude) {

        BoundingBoxDto boundingBoxDto = new BoundingBoxDto(
                BoundingBoxEnum.MINLON.getLatLon(), BoundingBoxEnum.MINLAT.getLatLon(),
                BoundingBoxEnum.MAXLON.getLatLon(), BoundingBoxEnum.MAXLAT.getLatLon());

        return boundingBoxDto.getMinLatitude() <= latitude
                && boundingBoxDto.getMaxLatitude() >= latitude
                && boundingBoxDto.getMinLongitude() <= longitude
                && boundingBoxDto.getMaxLongitude() >= longitude;

    }

}
