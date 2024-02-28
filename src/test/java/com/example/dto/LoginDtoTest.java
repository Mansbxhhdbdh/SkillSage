package com.example.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

import org.junit.jupiter.api.Test;

class LoginDtoTest {

    @Test
    void testConstructorAndGetterSetter() {
        Date dateFrom = new Date();
        Date dateTo = new Date();

        LoginDto loginDto = new LoginDto("test@example.com", "EMP001", "password", "ROLE_USER", "123456", "John Doe",
                "Project X", "Description", dateFrom, dateTo, "Developer", "Male");

        assertNotNull(loginDto);
        assertEquals("test@example.com", loginDto.getEmail());
        assertEquals("EMP001", loginDto.getEmpid());
        assertEquals("password", loginDto.getPassword());
        assertEquals("ROLE_USER", loginDto.getRole());
        assertEquals("123456", loginDto.getOtp());
        assertEquals("John Doe", loginDto.getFullname());
        assertEquals("Project X", loginDto.getProject());
        assertEquals("Description", loginDto.getPro_desc());
        assertEquals(dateFrom, loginDto.getDateFrom());
        assertEquals(dateTo, loginDto.getDateTo());
        assertEquals("Developer", loginDto.getDesignation());
		/* assertEquals("Male", loginDto.getGender()); */

        // Test setter methods
        loginDto.setEmail("new@example.com");
        assertEquals("new@example.com", loginDto.getEmail());

        loginDto.setEmpid("EMP002");
        assertEquals("EMP002", loginDto.getEmpid());

        loginDto.setPassword("newpassword");
        assertEquals("newpassword", loginDto.getPassword());

        loginDto.setRole("ROLE_ADMIN");
        assertEquals("ROLE_ADMIN", loginDto.getRole());

        loginDto.setOtp("654321");
        assertEquals("654321", loginDto.getOtp());

        loginDto.setFullname("Jane Doe");
        assertEquals("Jane Doe", loginDto.getFullname());

        loginDto.setProject("Project Y");
        assertEquals("Project Y", loginDto.getProject());

        loginDto.setPro_desc("New Description");
        assertEquals("New Description", loginDto.getPro_desc());

        Date newDateFrom = new Date();
        loginDto.setDateFrom(newDateFrom);
        assertEquals(newDateFrom, loginDto.getDateFrom());

        Date newDateTo = new Date();
        loginDto.setDateTo(newDateTo);
        assertEquals(newDateTo, loginDto.getDateTo());

        loginDto.setDesignation("Manager");
        assertEquals("Manager", loginDto.getDesignation());

		/*
		 * loginDto.setGender("Female"); assertEquals("Female", loginDto.getGender());
		 */
    }
}
