package com.zap.desafio.util;

import com.zap.desafio.dto.ImmobileDto;
import com.zap.desafio.exception.BusinessException;
import com.zap.desafio.exception.InvalidParametersException;
import com.zap.desafio.exception.MaximumLimitException;

import java.util.Set;
import java.util.stream.Collectors;

public class PartitionUtil {

    public static Set<ImmobileDto> partition(Set<ImmobileDto> set, int page, int limit) throws BusinessException {

        if ((page == 0 || limit == 0) || (page > limit)) throw new InvalidParametersException();

        if (limit > 50) throw new MaximumLimitException();

        int offset = 0;

        if (page > 1) offset = limit * (page - 1);

        Set<ImmobileDto> collect = set.stream().skip(offset).limit(limit).collect(Collectors.toSet());
        return collect;

    }

}
