package com.marmitou.base.exception;

import org.springframework.http.HttpStatus;

public class AssociationNotFoundException extends MarmitouException {

    public AssociationNotFoundException(String message) {
        super("ASSOCIATION_NOT_FOUND", message, HttpStatus.NOT_FOUND);
    }
}
