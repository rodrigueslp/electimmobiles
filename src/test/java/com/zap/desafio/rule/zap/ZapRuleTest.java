package com.zap.desafio.rule.zap;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ZapRuleTest {

    @InjectMocks
    private ZapRule zapRule;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void validRentalPrice_withRangeOut_shouldReturnFalse() {
        Boolean validRentalPrice = zapRule.validRentalPrice(new BigDecimal(3000), new BigDecimal(3500));
        assertFalse(validRentalPrice);
    }

    @Test
    public void validRentalPrice_withRangeIn_shouldReturnTrue() {
        Boolean validRentalPrice = zapRule.validRentalPrice(new BigDecimal(3501), new BigDecimal(3500));
        assertTrue(validRentalPrice);
    }

    @Test
    public void validSalePrice_withRangeOut_shouldReturnFalse() {
        Boolean validSalePrice = zapRule.validSalePrice(new BigDecimal(500000), new BigDecimal(600000));
        assertFalse(validSalePrice);
    }

    @Test
    public void validSalePrice_withRangeIn_shouldReturnTrue() {
        Boolean validSalePrice = zapRule.validSalePrice(new BigDecimal(600001), new BigDecimal(600000));
        assertTrue(validSalePrice);
    }

    @Test
    public void validLatLong_withLatZero_shouldReturnFalse() {
        Boolean validLatLong = zapRule.validLatLong(0, -46.716542);
        assertFalse(validLatLong);
    }

    @Test
    public void validLatLong_withLonZero_shouldReturnFalse() {
        Boolean validLatLong = zapRule.validLatLong(-23.502555, 0);
        assertFalse(validLatLong);
    }

    @Test
    public void validLatLong_withLonAndLatZero_shouldReturnFalse() {
        Boolean validLatLong = zapRule.validLatLong(0, 0);
        assertFalse(validLatLong);
    }

    @Test
    public void validLatLong_withValidLatAndLon_shouldReturnTrue() {
        Boolean validLatLong = zapRule.validLatLong(-23.502555, -46.716542);
        assertTrue(validLatLong);
    }

    @Test
    public void validUsableAreas_withInvalidValue_shouldReturnFalse() {
        Boolean validUsableAreas = zapRule.validUsableAreas(new BigDecimal(3000));
        assertFalse(validUsableAreas);
    }

    @Test
    public void validUsableAreas_withValidValue_shouldReturnFalse() {
        Boolean validUsableAreas = zapRule.validUsableAreas(new BigDecimal(3501));
        assertTrue(validUsableAreas);
    }
}