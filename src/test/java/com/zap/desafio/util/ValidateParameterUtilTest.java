package com.zap.desafio.util;

import com.zap.desafio.ImmobileToTest;
import com.zap.desafio.dto.ImmobileDto;
import com.zap.desafio.dto.ParameterDto;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ValidateParameterUtilTest {

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getImmobileValidateParameter_withoutParameters_shouldReturnParameterDto() {

        ParameterDto parameterDto = ValidateParameterUtil.getImmobileValidateParameter(null);

        assertThat(parameterDto.getPrice(), is(BigDecimal.ZERO));
        assertThat(parameterDto.getRentalPrice(), is(BigDecimal.ZERO));
        assertThat(parameterDto.getMonthlyCondoFee(), is(BigDecimal.ZERO));
        assertThat(parameterDto.getUsableAreas(), is(BigDecimal.ZERO));
        assertThat(parameterDto.getBusinessType(), is(""));
        assertThat(parameterDto.getLocationDto().getLat(), is(0.0));
        assertThat(parameterDto.getLocationDto().getLon(), is(0.0));

    }

    @Test
    public void getImmobileValidateParameter_withValidParameters_shouldReturnParameterDto() {

        ImmobileDto validImmobileDto = ImmobileToTest.getValidImmobileDto();
        ParameterDto parameterDto = ValidateParameterUtil.getImmobileValidateParameter(validImmobileDto);

        assertThat(parameterDto.getPrice(), is(validImmobileDto.getPricingInfos().getPrice()));
        assertThat(parameterDto.getRentalPrice(), is(validImmobileDto.getPricingInfos().getRentalTotalPrice()));
        assertThat(parameterDto.getMonthlyCondoFee(), is(validImmobileDto.getPricingInfos().getMonthlyCondoFee()));
        assertThat(parameterDto.getUsableAreas(), is(validImmobileDto.getUsableAreas()));
        assertThat(parameterDto.getBusinessType(), is(validImmobileDto.getPricingInfos().getBusinessType()));
        assertThat(parameterDto.getLocationDto().getLat(), is(validImmobileDto.getAddress().getGeoLocation().getLocation().getLat()));
        assertThat(parameterDto.getLocationDto().getLon(), is(validImmobileDto.getAddress().getGeoLocation().getLocation().getLon()));

    }
}