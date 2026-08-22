package com.marmitou.base.tenant;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class TenantContextTest {

    @AfterEach
    void tearDown() {
        TenantContext.clear();
    }

    @Test
    void setAndGetReturnsSameValue() {
        TenantContext.set(42L);
        assertEquals(42L, TenantContext.get());
    }

    @Test
    void getReturnsNullWhenNothingSet() {
        assertNull(TenantContext.get());
    }

    @Test
    void clearRemovesValue() {
        TenantContext.set(1L);
        TenantContext.clear();
        assertNull(TenantContext.get());
    }
}
