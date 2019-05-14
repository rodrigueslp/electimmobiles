package com.zap.desafio.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BoundingBoxUtilTest {

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void contains_insideOnBoundingBox_shouldReturnTrue() {
        boolean BBcontains = BoundingBoxUtil.contains(-23.558704, -46.673419);
        Assert.assertTrue(BBcontains);
    }

    @Test
    public void contains_withLatOutsideOnBoundingBox_shouldReturnFalse() {
        boolean BBcontains = BoundingBoxUtil.contains(-23.578704, -46.673419);
        Assert.assertFalse(BBcontains);
    }

    @Test
    public void contains_withLonOutsideOnBoundingBox_shouldReturnFalse() {
        boolean BBcontains = BoundingBoxUtil.contains(-23.558704, -46.698004);
        Assert.assertFalse(BBcontains);
    }

}
