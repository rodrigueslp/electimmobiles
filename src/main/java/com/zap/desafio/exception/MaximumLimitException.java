package com.zap.desafio.exception;

import org.springframework.http.HttpStatus;

public class MaximumLimitException extends BusinessException {

    public MaximumLimitException() {
        super("Maximum limit per page is 50 records.", HttpStatus.BAD_REQUEST);
    }

}
