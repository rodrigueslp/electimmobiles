package com.zap.desafio;

import com.zap.desafio.dto.*;

import java.math.BigDecimal;

public class ImmobileToTest {

    public static ImmobileDto getValidImmobileDto() {

        ImmobileDto immobileDto = new ImmobileDto();
        immobileDto.setUsableAreas(new BigDecimal(69));


        GeolocationDto geolocationDto = ImmobileToTest.getGeolocationDto("ROOFTOP", ImmobileToTest.getLocationDto(-46.716542, -23.502555));
        AddressDto addressDto = ImmobileToTest.getAddressDto("São Paulo", "Centro", geolocationDto);
        immobileDto.setAddress(addressDto);

        PricingInfosDto pricingInfosDto =ImmobileToTest.getPricingInfosDto("0", new BigDecimal(750000), new BigDecimal(0), "SALE", new BigDecimal(495));
        immobileDto.setPricingInfos(pricingInfosDto);

        return immobileDto;

    }

    public static LocationDto getLocationDto(double lan, double lon) {
        return new LocationDto(lan, lon);
    }

    public static GeolocationDto getGeolocationDto(String precision, LocationDto locationDto) {
        return new GeolocationDto(precision, locationDto);
    }

    public static AddressDto getAddressDto(String city, String neighborhood, GeolocationDto geolocationDto) {
        return new AddressDto(city, neighborhood, geolocationDto);
    }

    public static PricingInfosDto getPricingInfosDto(String yearlyIptu, BigDecimal price, BigDecimal rentalPrice, String businessType, BigDecimal monthlyCondoFee) {
        return new PricingInfosDto(yearlyIptu,price, rentalPrice, businessType, monthlyCondoFee);
    }

}
