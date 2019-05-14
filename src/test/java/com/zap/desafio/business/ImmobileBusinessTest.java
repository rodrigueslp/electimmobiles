package com.zap.desafio.business;

import com.zap.desafio.ImmobileToTest;
import com.zap.desafio.dto.ImmobileDto;
import com.zap.desafio.exception.BusinessException;
import com.zap.desafio.service.ImmobileService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class ImmobileBusinessTest {

    @InjectMocks
    private ImmobileBusiness immobileBusiness;

    @Mock
    private ImmobileService immobileService;

    @Mock
    private ElectImmobileBusiness electImmobileBusiness;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void elect_withValidImmobile_shouldInvokeElectMethod() throws BusinessException {

        when(immobileService.getImmobiles()).thenReturn(this.getValidImmobileDtos());

        immobileBusiness.elect();

        verify(electImmobileBusiness, times(1)).electToVivaReal(any());
        verify(electImmobileBusiness, times(1)).electToZap(any());

    }

    @Test
    public void elect_withInvalidImmobile_shouldntInvokeElectMethod() throws BusinessException {

        when(immobileService.getImmobiles()).thenReturn(null);

        immobileBusiness.elect();

        verify(electImmobileBusiness, never()).electToVivaReal(any());
        verify(electImmobileBusiness, never()).electToZap(any());

    }

    @Test
    public void elect_withoutAddressAndPricingInfos_shouldntInvokeElectMethod() throws BusinessException {

        ImmobileDto[] validImmobileDtos = this.getValidImmobileDtos();
        validImmobileDtos[0].setPricingInfos(null);
        validImmobileDtos[0].setAddress(null);

        when(immobileService.getImmobiles()).thenReturn(validImmobileDtos);

        immobileBusiness.elect();

        verify(electImmobileBusiness, never()).electToVivaReal(any());
        verify(electImmobileBusiness, never()).electToZap(any());

    }


    private ImmobileDto[] getValidImmobileDtos() {
        return new ImmobileDto[]{ImmobileToTest.getValidImmobileDto()};
    }
}
