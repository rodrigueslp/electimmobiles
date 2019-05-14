package com.zap.desafio.controller;

import com.zap.desafio.business.ImmobileBusiness;
import com.zap.desafio.dto.ImmobileDto;
import com.zap.desafio.dto.ImmobileOutputDto;
import com.zap.desafio.exception.BusinessException;
import com.zap.desafio.provider.ImmobileProvider;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/immobiles/")
@Api(value = "Immobiles", description = "Getting elegible immobiles to Zap and ViviReal")
public class ImmobileController {

    @Autowired
    private ImmobileBusiness immobileBusiness;

    @ApiOperation(value = "Getting elegible immobiles to VivaReal", response = ImmobileDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 404, message = "Invalid parameters"),
            @ApiResponse(code = 404, message = "Maximum limit per page is 50 records")
    })
    @RequestMapping(value= "/vivareal/{page}/{limit}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity vivaReal(@PathVariable int page, @PathVariable int limit) throws BusinessException {

        ImmobileOutputDto immobilesPartition = immobileBusiness.getImmobilesPartition(ImmobileProvider.immobileVivaReal, page, limit);

        return ResponseEntity.status(HttpStatus.OK).body(immobilesPartition);

    }

    @ApiOperation(value = "Getting elegible immobiles to Zap", response = ImmobileDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 404, message = "Invalid parameters"),
            @ApiResponse(code = 404, message = "Maximum limit per page is 50 records")
    })
    @RequestMapping(value ="/zap/{page}/{limit}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity zap(@PathVariable int page, @PathVariable int limit) throws BusinessException {

        ImmobileOutputDto immobilesParition = immobileBusiness.getImmobilesPartition(ImmobileProvider.immobileZap, page, limit);

        return ResponseEntity.status(HttpStatus.OK).body(immobilesParition);

    }

}
