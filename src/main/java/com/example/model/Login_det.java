package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.util.Date;

@Entity
@Table(name = "Login_details", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Login_det {
	
	@Id
	private String empid;
	private String email;
	private String password;
	private String role;
	private String fullname;
	private String project;
	private String pro_desc;
	private Date dateFrom;
	private Date dateTo;
	private String otp;
	private String designation; // New field
	private String gender;
	
	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}



	public Login_det(String empid, String email, String password, String role, String fullname, String project,
			String pro_desc, Date dateFrom, Date dateTo, String otp, String designation, String gender) {
		super();
		this.empid = empid;
		this.email = email;
		this.password = password;
		this.role = "USER";
		this.fullname = fullname;
		this.project = project;
		this.pro_desc = pro_desc;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.otp = otp;
		this.designation = designation;
		this.gender = gender;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	

	public void setGender(String gender) {
		// TODO Auto-generated method stub
		this.gender = gender;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getPro_desc() {
		return pro_desc;
	}

	public void setPro_desc(String pro_desc) {
		this.pro_desc = pro_desc;
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public Login_det() {
		super();
		// TODO Auto-generated constructor stub
	}
public Login_det orElse(Object object) {
		// TODO Auto-generated method stub
		
		return null;
	}

	



}
