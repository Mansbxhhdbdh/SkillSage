package com.example.logservice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dto.LoginDto;

import com.example.model.Login_det;
@Service
public interface LogService {
	
	Login_det save (LoginDto loginDto);

	Login_det getEmployeeById(long long1);

	 void updateEmployeeDetails(LoginDto loginDto);
	 
	List<Login_det>  getDetails (String email);

	
	

}
