package com.umb.taller.domain.exception;

public abstract class DomainException extends AppException {

    protected DomainException(String message) {
        super(message);
    }

    protected DomainException(String message, Throwable cause) {
        super(message, cause);
    }
}