package com.rkorp.logisticapi.domain.exception;

public class NotFoundEntityException extends BusinessException{
    public NotFoundEntityException(String message) {
        super(message);
    }
}
