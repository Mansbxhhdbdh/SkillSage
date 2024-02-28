package com.example.responses;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LoginResponseTest {

    @Test
    void testConstructorAndGetters() {
        // Given
        String message = "Login successful";
        boolean status = true;

        // When
        LoginResponse loginResponse = new LoginResponse(message, status);

        // Then
        assertEquals(message, loginResponse.getMessage());
        assertEquals(status, loginResponse.getStatus());
    }

    @Test
    void testSetters() {
        // Given
        LoginResponse loginResponse = new LoginResponse("Login successful", true);

        // When
        loginResponse.setMessage("Login failed");
        loginResponse.setStatus(false);

        // Then
        assertEquals("Login failed", loginResponse.getMessage());
        assertEquals(false, loginResponse.getStatus());
    }

    @Test
    void testToString() {
        // Given
        LoginResponse loginResponse = new LoginResponse("Login successful", true);

        // When
        String toStringResult = loginResponse.toString();

        // Then
        assertEquals("LoginResponse [message=Login successful, status=true]", toStringResult);
    }
}
