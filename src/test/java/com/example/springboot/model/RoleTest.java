package com.example.springboot.model;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RoleTest {

    @Test
    public void testGettersAndSetters() {
        // Given
        Long id = 1L;
        String roleName = "ROLE_USER";

        // When
        Role role = new Role();
        role.setId(id);
        role.setName(roleName);

        // Then
        assertEquals(id, role.getId());
        assertEquals(roleName, role.getName());
    }
}
