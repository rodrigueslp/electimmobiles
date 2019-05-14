package com.zap.desafio.exception;

import org.springframework.http.HttpStatus;

public class BusinessException extends Exception {

    private HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

    public BusinessException(String msg, HttpStatus status) {
        super(msg);
        this.setStatus(status);
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

}
