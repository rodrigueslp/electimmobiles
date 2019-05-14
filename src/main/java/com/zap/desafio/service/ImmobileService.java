package com.zap.desafio.service;

import com.zap.desafio.dto.ImmobileDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ImmobileService {

    private final String urlSource = "http://grupozap-code-challenge.s3-website-us-east-1.amazonaws.com/sources/source-2.json";

    public ImmobileDto[] getImmobiles() {

        RestTemplate restTemplate = new RestTemplate();
        ImmobileDto[] immobileDto = restTemplate.getForObject(urlSource, ImmobileDto[].class);
        return immobileDto;

    }

}
