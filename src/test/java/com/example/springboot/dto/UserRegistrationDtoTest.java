package com.example.springboot.dto;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UserRegistrationDtoTest {

    @Test
    public void testConstructorAndGetters() {
        // Given
        String firstName = "John";
        String lastName = "Doe";
        String email = "john.doe@example.com";
        String password = "password";

        // When
        UserRegistrationDto userRegistrationDto = new UserRegistrationDto(firstName, lastName, email, password);

        // Then
        assertEquals(firstName, userRegistrationDto.getFirstName());
        assertEquals(lastName, userRegistrationDto.getLastName());
        assertEquals(email, userRegistrationDto.getEmail());
        assertEquals(password, userRegistrationDto.getPassword());
    }

    @Test
    public void testSetters() {
        // Given
        UserRegistrationDto userRegistrationDto = new UserRegistrationDto();

        // When
        userRegistrationDto.setFirstName("Jane");
        userRegistrationDto.setLastName("Doe");
        userRegistrationDto.setEmail("jane.doe@example.com");
        userRegistrationDto.setPassword("newPassword");

        // Then
        assertEquals("Jane", userRegistrationDto.getFirstName());
        assertEquals("Doe", userRegistrationDto.getLastName());
        assertEquals("jane.doe@example.com", userRegistrationDto.getEmail());
        assertEquals("newPassword", userRegistrationDto.getPassword());
    }
}
