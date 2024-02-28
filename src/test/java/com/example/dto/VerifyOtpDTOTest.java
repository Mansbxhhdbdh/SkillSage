package com.example.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class VerifyOtpDTOTest {

    @Test
    void testGetEmail() {
        VerifyOtpDTO verifyOtpDTO = new VerifyOtpDTO("test@example.com", "123456");
        assertEquals("test@example.com", verifyOtpDTO.getEmail());
    }

    @Test
    void testSetEmail() {
        VerifyOtpDTO verifyOtpDTO = new VerifyOtpDTO();
        verifyOtpDTO.setEmail("test@example.com");
        assertEquals("test@example.com", verifyOtpDTO.getEmail());
    }

    @Test
    void testGetOtp() {
        VerifyOtpDTO verifyOtpDTO = new VerifyOtpDTO("test@example.com", "123456");
        assertEquals("123456", verifyOtpDTO.getOtp());
    }

    @Test
    void testSetOtp() {
        VerifyOtpDTO verifyOtpDTO = new VerifyOtpDTO();
        verifyOtpDTO.setOtp("123456");
        assertEquals("123456", verifyOtpDTO.getOtp());
    }

    @Test
    void testConstructor() {
        VerifyOtpDTO verifyOtpDTO = new VerifyOtpDTO("test@example.com", "123456");
        assertEquals("test@example.com", verifyOtpDTO.getEmail());
        assertEquals("123456", verifyOtpDTO.getOtp());
    }
}
