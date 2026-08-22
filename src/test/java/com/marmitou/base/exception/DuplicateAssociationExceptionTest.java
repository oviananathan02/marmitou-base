package com.marmitou.base.exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DuplicateAssociationExceptionTest {

    @Test
    void buildsCodeMessageAndStatus() {
        DuplicateAssociationException exception = new DuplicateAssociationException("already linked");

        assertEquals("DUPLICATE_ASSOCIATION", exception.getCode());
        assertEquals("already linked", exception.getMessage());
        assertEquals(HttpStatus.CONFLICT, exception.getStatus());
    }
}
