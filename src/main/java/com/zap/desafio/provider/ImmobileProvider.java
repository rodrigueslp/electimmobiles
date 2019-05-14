package com.zap.desafio.provider;

import com.zap.desafio.dto.ImmobileDto;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ImmobileProvider {

    public static Set<ImmobileDto> immobileVivaReal = new HashSet<ImmobileDto>();

    public static Set<ImmobileDto> immobileZap = new HashSet<ImmobileDto>();

    public void addImmobileVivaReal(ImmobileDto immobileDto) {
        immobileVivaReal.add(immobileDto);
    }

    public void addImmobileZap(ImmobileDto immobileDto) {
        immobileZap.add(immobileDto);
    }

}
