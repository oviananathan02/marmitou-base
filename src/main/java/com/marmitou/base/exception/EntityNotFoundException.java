package com.marmitou.base.exception;

import org.springframework.http.HttpStatus;

import java.util.UUID;

public class EntityNotFoundException extends MarmitouException {

    public EntityNotFoundException(String entitySimpleName, UUID uuid) {
        super(
            entitySimpleName.replace("Entity", "").toUpperCase() + "_NOT_FOUND",
            entitySimpleName.replace("Entity", "") + " não encontrado(a): " + uuid,
            HttpStatus.NOT_FOUND
        );
    }
}
