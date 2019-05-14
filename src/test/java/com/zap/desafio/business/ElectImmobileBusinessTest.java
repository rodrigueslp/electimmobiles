package com.zap.desafio.business;

import com.zap.desafio.ImmobileToTest;
import com.zap.desafio.dto.ImmobileDto;
import com.zap.desafio.enumerator.BusinessTypeEnum;
import com.zap.desafio.provider.ImmobileProvider;
import com.zap.desafio.rule.vivareal.VivaRealRule;
import com.zap.desafio.rule.zap.ZapRule;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class ElectImmobileBusinessTest {

    @InjectMocks
    private ElectImmobileBusiness electImmobileBusiness;

    @Mock
    private VivaRealRule vivaRealRule;

    @Mock
    private ZapRule zapRule;

    @Mock
    private ImmobileProvider immobileProvider;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void electToVivaReal_withInvalidParameters_shouldntAddImmobile() {

        ImmobileDto immobileDto = new ImmobileDto();
        electImmobileBusiness.electToVivaReal(immobileDto);

        verify(immobileProvider, never()).addImmobileVivaReal(immobileDto);

    }

    @Test
    public void electToVivalReal_withBusinessTypeBeingSaleAndValidParameters_shouldAddImmobile() {

        ImmobileDto validImmobileDto = ImmobileToTest.getValidImmobileDto();
        validImmobileDto.getPricingInfos().setBusinessType(BusinessTypeEnum.SALE.getBusinessType());

        when(vivaRealRule.validSalePrice(validImmobileDto.getPricingInfos().getPrice(), new BigDecimal(700000))).thenReturn(Boolean.TRUE);

        when(vivaRealRule.validLatLong(validImmobileDto.getAddress().getGeoLocation().getLocation().getLat(),
                validImmobileDto.getAddress().getGeoLocation().getLocation().getLon())).thenReturn(Boolean.TRUE);

        electImmobileBusiness.electToVivaReal(validImmobileDto);

        verify(immobileProvider, times(1)).addImmobileVivaReal(validImmobileDto);

    }

    @Test
    public void electToVivalReal_withBusinessTypeBeingRentalValidParameters_shouldAddImmobile() {

        ImmobileDto validImmobileDto = ImmobileToTest.getValidImmobileDto();
        validImmobileDto.getPricingInfos().setBusinessType(BusinessTypeEnum.RENTAL.getBusinessType());

        when(vivaRealRule.validRentalPrice(validImmobileDto.getPricingInfos().getRentalTotalPrice(), new BigDecimal(4000))).thenReturn(Boolean.TRUE);
        when(vivaRealRule.validLimitCondominiumValue(validImmobileDto.getPricingInfos().getRentalTotalPrice(),
                validImmobileDto.getPricingInfos().getMonthlyCondoFee())).thenReturn(Boolean.TRUE);

        when(vivaRealRule.validLatLong(validImmobileDto.getAddress().getGeoLocation().getLocation().getLat(),
                validImmobileDto.getAddress().getGeoLocation().getLocation().getLon())).thenReturn(Boolean.TRUE);

        electImmobileBusiness.electToVivaReal(validImmobileDto);

        verify(immobileProvider, times(1)).addImmobileVivaReal(validImmobileDto);

    }

    @Test
    public void electToZap_withBusinessTypeBeingSaleAndValidParameters_shouldAddImmobile() {

        ImmobileDto validImmobileDto = ImmobileToTest.getValidImmobileDto();
        validImmobileDto.getPricingInfos().setBusinessType(BusinessTypeEnum.SALE.getBusinessType());

        when(zapRule.validSalePrice(validImmobileDto.getPricingInfos().getPrice(), new BigDecimal(600000))).thenReturn(Boolean.TRUE);

        when(zapRule.validLatLong(validImmobileDto.getAddress().getGeoLocation().getLocation().getLat(),
                validImmobileDto.getAddress().getGeoLocation().getLocation().getLon())).thenReturn(Boolean.TRUE);

        electImmobileBusiness.electToZap(validImmobileDto);

        verify(immobileProvider, times(1)).addImmobileZap(validImmobileDto);

    }

    @Test
    public void electToZap_withBusinessTypeBeingRentalValidParameters_shouldAddImmobile() {

        ImmobileDto validImmobileDto = ImmobileToTest.getValidImmobileDto();
        validImmobileDto.getPricingInfos().setBusinessType(BusinessTypeEnum.RENTAL.getBusinessType());

        when(zapRule.validRentalPrice(validImmobileDto.getPricingInfos().getRentalTotalPrice(), new BigDecimal(3500))).thenReturn(Boolean.TRUE);
        when(zapRule.validUsableAreas(validImmobileDto.getUsableAreas())).thenReturn(Boolean.TRUE);

        when(zapRule.validLatLong(validImmobileDto.getAddress().getGeoLocation().getLocation().getLat(),
                validImmobileDto.getAddress().getGeoLocation().getLocation().getLon())).thenReturn(Boolean.TRUE);

        electImmobileBusiness.electToZap(validImmobileDto);

        verify(immobileProvider, times(1)).addImmobileZap(validImmobileDto);

    }

    @Test
    public void elect_withBusinessTypeInvalid_shouldntAddImmobile() {

        ImmobileDto validImmobileDto = ImmobileToTest.getValidImmobileDto();
        validImmobileDto.getPricingInfos().setBusinessType("TESTE");

        electImmobileBusiness.electToZap(validImmobileDto);
        electImmobileBusiness.electToVivaReal(validImmobileDto);

        verify(immobileProvider, never()).addImmobileZap(validImmobileDto);

    }

}
