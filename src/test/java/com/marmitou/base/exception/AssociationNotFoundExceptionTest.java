package com.marmitou.base.exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AssociationNotFoundExceptionTest {

    @Test
    void buildsCodeMessageAndStatus() {
        AssociationNotFoundException exception = new AssociationNotFoundException("not linked");

        assertEquals("ASSOCIATION_NOT_FOUND", exception.getCode());
        assertEquals("not linked", exception.getMessage());
        assertEquals(HttpStatus.NOT_FOUND, exception.getStatus());
    }
}
