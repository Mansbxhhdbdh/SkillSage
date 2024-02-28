package com.example.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.example.model.Login_det;

class EmployeeSkillTest {

    @Test
    void testConstructorAndGetterSetter() {
        // Create necessary dependencies
        EmpID empID = new EmpID("EMP001", 12345);
        Login_det loginDet = new Login_det(); // You might need to provide necessary data for this object
        Skills skills = new Skills(); // You might need to provide necessary data for this object

        // Create EmployeeSkill instance
        EmployeeSkill employeeSkill = new EmployeeSkill(empID, loginDet, skills, "Proficient", "5 years", "Certification");

        // Perform assertions
        assertNotNull(employeeSkill);
        assertEquals(empID, employeeSkill.getId());
        assertEquals(loginDet, employeeSkill.getLogin_det());
        assertEquals(skills, employeeSkill.getSkills());
        assertEquals("Proficient", employeeSkill.getProficiency());
        assertEquals("5 years", employeeSkill.getExp());
        assertEquals("Certification", employeeSkill.getCert_source());

        // Test setter methods
        EmpID newEmpID = new EmpID("EMP002", 54321);
        employeeSkill.setId(newEmpID);
        assertEquals(newEmpID, employeeSkill.getId());

        Login_det newLoginDet = new Login_det(); // You might need to provide necessary data for this object
        employeeSkill.setLogin_det(newLoginDet);
        assertEquals(newLoginDet, employeeSkill.getLogin_det());

        Skills newSkills = new Skills(); // You might need to provide necessary data for this object
        employeeSkill.setSkills(newSkills);
        assertEquals(newSkills, employeeSkill.getSkills());

        employeeSkill.setProficiency("Intermediate");
        assertEquals("Intermediate", employeeSkill.getProficiency());

        employeeSkill.setExp("3 years");
        assertEquals("3 years", employeeSkill.getExp());

        employeeSkill.setCert_source("Course completion");
        assertEquals("Course completion", employeeSkill.getCert_source());
    }
}
