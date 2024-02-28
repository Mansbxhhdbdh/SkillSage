package com.example.entity;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class UpdateDomainRequestTest {

    @Test
    void testConstructorAndGetterSetter() {
        // Create UpdateDomainRequest instance
        UpdateDomainRequest request = new UpdateDomainRequest("Old Domain", "New Domain");

        // Perform assertions
        assertNotNull(request);
        assertEquals("Old Domain", request.getDomain());
        assertEquals("New Domain", request.getEditedDomain());

        // Test setter methods
        request.setDomain("Previous Domain");
        assertEquals("Previous Domain", request.getDomain());

        request.setEditedDomain("Modified Domain");
        assertEquals("Modified Domain", request.getEditedDomain());
    }

    @Test
    void testEmptyConstructor() {
        // Create UpdateDomainRequest instance using empty constructor
        UpdateDomainRequest request = new UpdateDomainRequest();

        // Perform assertions
        assertNotNull(request);
        assertEquals(null, request.getDomain());
        assertEquals(null, request.getEditedDomain());

        // Test setter methods
        request.setDomain("New Domain");
        assertEquals("New Domain", request.getDomain());

        request.setEditedDomain("Updated Domain");
        assertEquals("Updated Domain", request.getEditedDomain());
    }
}
