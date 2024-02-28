package com.example.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.security.Principal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.example.controller.EmpSkillController;
import com.example.entity.EmployeeSkill;
import com.example.service.EmpSkillService;

@ExtendWith(MockitoExtension.class)
public class EmpSkillControllerTest {

    @InjectMocks
    EmpSkillController controller;

    @Mock
    EmpSkillService service;



    @Test
    public void testShowSkillDetails1() {
        // Test setup
        Model model = mock(Model.class);
        Principal principal = mock(Principal.class);
        when(principal.getName()).thenReturn("testEmpId");

        // Method call
        String result = controller.showSkillDetails(model, principal);

        // Verification
        assertEquals("skillDetails", result);
    }

    @Test
    public void testShowAddEmpSkillForm() {
        // Method call
        String result = controller.showAddEmpSkillForm(mock(Model.class));

        // Verification
        assertEquals("addEmpSkill", result);
    }

    @Test
    public void testAddSkill() {
        // Test setup
        EmployeeSkill employeeSkill = new EmployeeSkill();
        BindingResult bindingResult = mock(BindingResult.class);

        // Method call
        String result = controller.addSkill(employeeSkill, bindingResult);

        // Verification
        assertEquals("success", result);
        verify(service, times(1)).saveEmpSkill(employeeSkill);
    }
    @Test
    public void testShowSkillDetails() {
        // Test setup
        Model model = mock(Model.class);
        List<EmployeeSkill> employeeSkills = new ArrayList<>();
        when(service.getEmpSkills()).thenReturn(employeeSkills);

        // Method call
        String result = controller.showSkillDetails(model);

        // Verification
        assertEquals("AEmpSkill", result);
        verify(model, times(1)).addAttribute(eq("employeeSkills"), eq(employeeSkills));
    }

    @Test
    public void testDeleteEmployeeSkills() {
        // Test setup
        List<String> empSkillIds = new ArrayList<>();
        empSkillIds.add("testEmpId-1");

        // Method call
        String result = controller.deleteEmployeeSkills(empSkillIds);

        // Verification
        assertEquals("redirect:/deleteEmpSkills1", result);
        verify(service, times(1)).deleteEmpSkill("testEmpId", 1);
    }

    // Add more test cases for other methods as needed

}

