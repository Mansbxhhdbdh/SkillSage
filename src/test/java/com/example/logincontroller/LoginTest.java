package com.example.logincontroller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.context.WebApplicationContext;

import com.example.dto.LoginDto;
import com.example.dto.VerifyOtpDTO;
import com.example.logincontroller.login;
import com.example.logrepo.logRepository;
import com.example.logservice.LogService;
import com.example.logservice.LoginDetService;
import com.example.model.Login_det;

@ExtendWith(MockitoExtension.class)
class LoginTest {

    @Mock
    private logRepository logrepo;

    @Mock
    private LoginDetService loginDetService;

    @Mock
    private LogService logService;

    @Mock
    private WebApplicationContext webApplicationContext;

    @InjectMocks
    private login loginController;

    @Test
    void landingPage() {
        assertEquals("home", loginController.landingPage());
    }

    @Test
    void showLoginDetails() {
        List<Login_det> loginDetList = new ArrayList<>();
        when(loginDetService.getLoginDets()).thenReturn(loginDetList);
        Model model = mock(Model.class);
        assertEquals("EmpDetails", loginController.showLoginDetails(model));
    }

    @Test
    void getRegistrationPage() {
        Model model = mock(Model.class);
        assertEquals("register", loginController.getRegistrationPage(new LoginDto(), model));
    }

    @Test
    void llogin() {
        Model model = mock(Model.class);
        assertEquals("login", loginController.llogin(new LoginDto(), model));
    }

    @Test
    void employeees() {
        assertEquals("EmpDash", loginController.employeees());
    }

   

    

    @Test
    void getAllLoginDetails() {
        Model model = mock(Model.class);
        assertEquals("login_details", loginController.getAllLoginDetails(model));
    }

    @Test
    void deleteLoginDetail() {
        assertEquals("redirect:/login-details", loginController.deleteLoginDetail("123"));
    }

    @Test
    void forgot() {
        assertEquals("forgot", loginController.forgot());
    }

    @Test
    void sendOtpToMail() {
        assertEquals("success", loginController.sendOtpToMail("example@example.com", new Login_det()));
    }

   
   


    @Test
    void updateEmployeeDetails() {
        Model model = mock(Model.class);
        assertEquals("employee_details", loginController.updateEmployeeDetails(new LoginDto(), model));
    }

    @Test
    void saveUser() {
        Model model = mock(Model.class);
        assertEquals("register", loginController.saveUser(new Login_det(), model));
    }

   
}
