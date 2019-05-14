package com.zap.desafio.rule.vivareal;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class VivaRealRuleTest {

    @InjectMocks
    private VivaRealRule vivaRealRule;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void validRentalPrice_withRangeOut_shouldReturnFalse() {
        Boolean validRentalPrice = vivaRealRule.validRentalPrice(new BigDecimal(5000), new BigDecimal(4000));
        assertFalse(validRentalPrice);
    }

    @Test
    public void validRentalPrice_withRangeIn_shouldReturnTrue() {
        Boolean validRentalPrice = vivaRealRule.validRentalPrice(new BigDecimal(3500), new BigDecimal(4000));
        assertTrue(validRentalPrice);
    }

    @Test
    public void validSalePrice_withRangeOut_shouldReturnFalse() {
        Boolean validSalePrice = vivaRealRule.validSalePrice(new BigDecimal(800000), new BigDecimal(700000));
        assertFalse(validSalePrice);
    }

    @Test
    public void validSalePrice_withRangeIn_shouldReturnTrue() {
        Boolean validSalePrice = vivaRealRule.validSalePrice(new BigDecimal(600000), new BigDecimal(700000));
        assertTrue(validSalePrice);
    }

    @Test
    public void validLatLong_withLatZero_shouldReturnFalse() {
        Boolean validLatLong = vivaRealRule.validLatLong(0, -46.716542);
        assertFalse(validLatLong);
    }

    @Test
    public void validLatLong_withLonZero_shouldReturnFalse() {
        Boolean validLatLong = vivaRealRule.validLatLong(-23.502555, 0);
        assertFalse(validLatLong);
    }

    @Test
    public void validLatLong_withLonAndLatZero_shouldReturnFalse() {
        Boolean validLatLong = vivaRealRule.validLatLong(0, 0);
        assertFalse(validLatLong);
    }

    @Test
    public void validLatLong_withValidLatAndLon_shouldReturnTrue() {
        Boolean validLatLong = vivaRealRule.validLatLong(-23.502555, -46.716542);
        assertTrue(validLatLong);
    }

    @Test
    public void validLimitCondominiumValue_withInvalidCondominiumValue_shouldReturnFalse() {
        Boolean validLimitCondominiumValue = vivaRealRule.validLimitCondominiumValue(new BigDecimal(3500), new BigDecimal(1100));
        assertFalse(validLimitCondominiumValue);
    }

    @Test
    public void validLimitCondominiumValue_withValidCondominiumValue_shouldReturnTrue() {
        Boolean validLimitCondominiumValue = vivaRealRule.validLimitCondominiumValue(new BigDecimal(3500), new BigDecimal(500));
        assertTrue(validLimitCondominiumValue);
    }
}