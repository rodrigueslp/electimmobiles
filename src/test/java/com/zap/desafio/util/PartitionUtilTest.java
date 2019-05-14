package com.zap.desafio.util;

import com.zap.desafio.ImmobileToTest;
import com.zap.desafio.dto.ImmobileDto;
import com.zap.desafio.exception.BusinessException;
import com.zap.desafio.exception.InvalidParametersException;
import com.zap.desafio.exception.MaximumLimitException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class PartitionUtilTest {

    @InjectMocks
    private PartitionUtil partitionUtil;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void partition_withInvalidParameters_shouldInvokeInvalidParametersException() throws BusinessException {

        try {
            PartitionUtil.partition(Mockito.anySet(), 0, 0);
            fail("Faield test");
        } catch (InvalidParametersException e) {
            assertThat(e.getMessage(), is("Invalid parameters."));
        }

    }

    @Test
    public void partition_withInvalidLimitNumber_shouldInvokeMaximumLimitException() throws BusinessException {

        try {
            PartitionUtil.partition(Mockito.anySet(), 1, 51);
            fail("Faield test");
        } catch (MaximumLimitException e) {
            assertThat(e.getMessage(), is("Maximum limit per page is 50 records."));
        }

    }

    @Test
    public void partition_withValidParameters_shouldReturnSet() throws BusinessException {

        Set<ImmobileDto> immobile = new HashSet<ImmobileDto>();
        for (int i = 0; i <= 60; i++) {
            immobile.add(ImmobileToTest.getValidImmobileDto());
        }

        Set<ImmobileDto> partition = PartitionUtil.partition(immobile, 1, 50);

        assertThat(partition.size(), is(50));

    }
}