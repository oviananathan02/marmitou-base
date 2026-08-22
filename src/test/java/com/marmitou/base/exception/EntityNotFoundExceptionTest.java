package com.marmitou.base.exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EntityNotFoundExceptionTest {

    @Test
    void buildsCodeAndMessageFromEntitySimpleName() {
        UUID uuid = UUID.randomUUID();

        EntityNotFoundException exception = new EntityNotFoundException("UserEntity", uuid);

        assertEquals("USER_NOT_FOUND", exception.getCode());
        assertTrue(exception.getMessage().contains("User"));
        assertTrue(exception.getMessage().contains(uuid.toString()));
        assertEquals(HttpStatus.NOT_FOUND, exception.getStatus());
    }
}
