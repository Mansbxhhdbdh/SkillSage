package com.example.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class UpdateSubdomainRequestTest {

    @Test
    void testConstructorAndGetterSetter() {
        // Create UpdateSubdomainRequest instance
        UpdateSubdomainRequest request = new UpdateSubdomainRequest("Domain", "Subdomain", "EditedSubdomain");

        // Perform assertions
        assertNotNull(request);
        assertEquals("Domain", request.getDomain());
        assertEquals("Subdomain", request.getSubdomain());
        assertEquals("EditedSubdomain", request.getEditedSubdomain());

        // Test setter methods
        request.setDomain("NewDomain");
        assertEquals("NewDomain", request.getDomain());

        request.setSubdomain("NewSubdomain");
        assertEquals("NewSubdomain", request.getSubdomain());

        request.setEditedSubdomain("NewEditedSubdomain");
        assertEquals("NewEditedSubdomain", request.getEditedSubdomain());
    }

    @Test
    void testEmptyConstructor() {
        // Create UpdateSubdomainRequest instance using empty constructor
        UpdateSubdomainRequest request = new UpdateSubdomainRequest();

        // Perform assertions
        assertNotNull(request);
        assertEquals(null, request.getDomain());
        assertEquals(null, request.getSubdomain());
        assertEquals(null, request.getEditedSubdomain());

        // Test setter methods
        request.setDomain("NewDomain");
        assertEquals("NewDomain", request.getDomain());

        request.setSubdomain("NewSubdomain");
        assertEquals("NewSubdomain", request.getSubdomain());

        request.setEditedSubdomain("NewEditedSubdomain");
        assertEquals("NewEditedSubdomain", request.getEditedSubdomain());
    }
}
