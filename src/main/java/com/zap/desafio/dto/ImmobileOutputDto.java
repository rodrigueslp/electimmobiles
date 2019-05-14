package com.zap.desafio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImmobileOutputDto {

    private int pageNumber;

    private int pageSize;

    private int totalCount;

    private Set<ImmobileDto> listings;

}
