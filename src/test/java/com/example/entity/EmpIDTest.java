package com.example.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class EmpIDTest {

    @Test
    void testConstructorAndGetterSetter() {
        EmpID empID = new EmpID("EMP001", 12345);

        assertNotNull(empID);
        assertEquals("EMP001", empID.getEmpid());
        assertEquals(12345, empID.getSkillid());

        // Test setter methods
        empID.setEmpid("EMP002");
        assertEquals("EMP002", empID.getEmpid());

        empID.setSkillid(54321);
        assertEquals(54321, empID.getSkillid());
    }
}
