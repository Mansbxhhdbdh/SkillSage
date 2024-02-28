package com.example.entity;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class UpdateSkillnameRequestTest {

    @Test
    void testConstructorAndGetterSetter() {
        // Create UpdateSkillnameRequest instance
        UpdateSkillnameRequest request = new UpdateSkillnameRequest("Domain", "Subdomain", "SkillName", "EditedSkillName");

        // Perform assertions
        assertNotNull(request);
        assertEquals("Domain", request.getDomain());
        assertEquals("Subdomain", request.getSubdomain());
        assertEquals("SkillName", request.getSkillname());
        assertEquals("EditedSkillName", request.getEditedSkillname());

        // Test setter methods
        request.setDomain("NewDomain");
        assertEquals("NewDomain", request.getDomain());

        request.setSubdomain("NewSubdomain");
        assertEquals("NewSubdomain", request.getSubdomain());

        request.setSkillname("NewSkillName");
        assertEquals("NewSkillName", request.getSkillname());

        request.setEditedSkillname("NewEditedSkillName");
        assertEquals("NewEditedSkillName", request.getEditedSkillname());
    }

    @Test
    void testEmptyConstructor() {
        // Create UpdateSkillnameRequest instance using empty constructor
        UpdateSkillnameRequest request = new UpdateSkillnameRequest();

        // Perform assertions
        assertNotNull(request);
        assertEquals(null, request.getDomain());
        assertEquals(null, request.getSubdomain());
        assertEquals(null, request.getSkillname());
        assertEquals(null, request.getEditedSkillname());

        // Test setter methods
        request.setDomain("NewDomain");
        assertEquals("NewDomain", request.getDomain());

        request.setSubdomain("NewSubdomain");
        assertEquals("NewSubdomain", request.getSubdomain());

        request.setSkillname("NewSkillName");
        assertEquals("NewSkillName", request.getSkillname());

        request.setEditedSkillname("NewEditedSkillName");
        assertEquals("NewEditedSkillName", request.getEditedSkillname());
    }
}
