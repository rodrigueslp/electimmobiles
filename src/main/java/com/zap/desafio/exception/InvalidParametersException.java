package com.zap.desafio.exception;

import org.springframework.http.HttpStatus;

public class InvalidParametersException extends BusinessException {

    public InvalidParametersException() {
        super("Invalid parameters.", HttpStatus.BAD_REQUEST);
    }

}
