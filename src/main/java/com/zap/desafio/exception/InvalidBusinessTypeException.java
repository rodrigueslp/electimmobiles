package com.zap.desafio.exception;

import org.springframework.http.HttpStatus;

public class InvalidBusinessTypeException extends BusinessException {

    public InvalidBusinessTypeException() {
        super("Invalid business type.", HttpStatus.BAD_REQUEST);
    }
}
