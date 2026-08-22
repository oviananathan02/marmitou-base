package com.marmitou.base.exception;

import org.springframework.http.HttpStatus;

public class DuplicateAssociationException extends MarmitouException {

    public DuplicateAssociationException(String message) {
        super("DUPLICATE_ASSOCIATION", message, HttpStatus.CONFLICT);
    }
}
