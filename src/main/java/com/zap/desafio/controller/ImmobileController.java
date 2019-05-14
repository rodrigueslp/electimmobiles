package com.zap.desafio.controller;

import com.zap.desafio.business.ImmobileBusiness;
import com.zap.desafio.dto.ImmobileOutputDto;
import com.zap.desafio.exception.BusinessException;
import com.zap.desafio.provider.ImmobileProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/immobiles/")
public class ImmobileController {

    @Autowired
    private ImmobileBusiness immobileBusiness;

    @GetMapping
    @RequestMapping("/vivareal/{page}/{limit}")
    public ResponseEntity vivaReal(@PathVariable int page, @PathVariable int limit) throws BusinessException {

        ImmobileOutputDto immobilesPartition = immobileBusiness.getImmobilesPartition(ImmobileProvider.immobileVivaReal, page, limit);

        return ResponseEntity.status(HttpStatus.OK).body(immobilesPartition);

    }

    @GetMapping
    @RequestMapping("/zap/{page}/{limit}")
    public ResponseEntity zap(@PathVariable int page, @PathVariable int limit) throws BusinessException {

        ImmobileOutputDto immobilesParition = immobileBusiness.getImmobilesPartition(ImmobileProvider.immobileZap, page, limit);

        return ResponseEntity.status(HttpStatus.OK).body(immobilesParition);

    }

}
