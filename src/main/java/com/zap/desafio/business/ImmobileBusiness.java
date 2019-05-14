package com.zap.desafio.business;

import com.zap.desafio.dto.ImmobileDto;
import com.zap.desafio.dto.ImmobileOutputDto;
import com.zap.desafio.exception.BusinessException;
import com.zap.desafio.rule.vivareal.VivaRealRule;
import com.zap.desafio.rule.zap.ZapRule;
import com.zap.desafio.service.ImmobileService;
import com.zap.desafio.util.PartitionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service
public class ImmobileBusiness {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImmobileBusiness.class);

    @Autowired
    private ImmobileService immobileService;

    @Autowired
    private ElectImmobileBusiness electImmobileBusiness;

    public void elect() throws BusinessException {

        ImmobileDto[] immobiles = immobileService.getImmobiles();

        if (Objects.nonNull(immobiles) && immobiles.length > 0) {
            for (int i =0; i < immobiles.length; i++) {

                if (Objects.isNull(immobiles[i].getPricingInfos())
                        || Objects.isNull(immobiles[i].getAddress().getGeoLocation().getLocation())) {
                    return;
                }

                electImmobileBusiness.electToVivaReal(immobiles[i]);
                electImmobileBusiness.electToZap(immobiles[i]);

                LOGGER.info("### Immobile: " + i + " Executing immobiles validation ###");

            }

            LOGGER.info("Immobiles validation finished");
        } else {

            LOGGER.info("No eligible immobile");

        }



    }

    public ImmobileOutputDto getImmobilesPartition(Set<ImmobileDto> immobiles, int page, int limit) throws BusinessException {

        Set<ImmobileDto> immobilesPartition = PartitionUtil.partition(immobiles, page, limit);

        return new ImmobileOutputDto(page, limit, immobiles.size(), immobilesPartition);

    }


}
