package com.example.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class SkillsTest {

    @Test
    void testConstructorAndGetterSetter() {
        // Create Skills instance
        Skills skills = new Skills(1, "Java Programming", "Backend Development", "Programming");

        // Perform assertions
        assertNotNull(skills);
        assertEquals(1, skills.getSkillid());
        assertEquals("Java Programming", skills.getSkillname());
        assertEquals("Backend Development", skills.getSubdomain());
        assertEquals("Programming", skills.getDomain());

        // Test setter methods
        skills.setSkillid(2);
        assertEquals(2, skills.getSkillid());

        skills.setSkillname("Python Programming");
        assertEquals("Python Programming", skills.getSkillname());

        skills.setSubdomain("Data Science");
        assertEquals("Data Science", skills.getSubdomain());

        skills.setDomain("Machine Learning");
        assertEquals("Machine Learning", skills.getDomain());
    }
}
