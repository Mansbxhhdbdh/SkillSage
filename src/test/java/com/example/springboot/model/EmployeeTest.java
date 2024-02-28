package com.example.springboot.model;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EmployeeTest {

    @Test
    public void testGettersAndSetters() {
        // Given
        long id = 1;
        String firstName = "John";
        String lastName = "Doe";
        String email = "john.doe@example.com";

        // When
        Employee employee = new Employee();
        employee.setId(id);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setEmail(email);

        // Then
        assertEquals(id, employee.getId());
        assertEquals(firstName, employee.getFirstName());
        assertEquals(lastName, employee.getLastName());
        assertEquals(email, employee.getEmail());
    }
}
