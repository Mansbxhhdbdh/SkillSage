package com.example.logservice;



import java.security.SecureRandom;
import java.util.Date;
import java.util.List;

import org.eclipse.angus.mail.smtp.SMTPSendFailedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.dto.LoginDto;
import com.example.dto.VerifyOtpDTO;
import com.example.logrepo.logRepository;
import com.example.model.Login_det;
import com.example.service.EmpSkillService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.transaction.Transactional;


@Service
@Retryable(value = { SMTPSendFailedException.class }, maxAttempts = 3, backoff = @Backoff(delay = 5000))

public class LoginDetService {
    @Autowired
    private logRepository repository;
    
    @Autowired
    private JavaMailSender javaMailSender;
    
    

    public Login_det saveLoginDet(Login_det loginDet) {
        return repository.save(loginDet);
    }

    public List<Login_det> saveLoginDets(List<Login_det> loginDets) {
        return repository.saveAll(loginDets);
    }

    public List<Login_det> getLoginDets() {
        return repository.findAll();
    }

    public Login_det getLoginDetByEmpId(String empid) {
        return repository.findByEmpid(empid).orElse(null);
    }

    public Login_det getLoginDetByEmail(String email) {
        return repository.findByEmail(email).orElse(null);
    }
    
    @Autowired
   	private EmpSkillService service;

       @Transactional
       public void deleteLoginDet(String empId) {
       	service.deleteEmpSkillByEmpId(empId);
           repository.deleteByEmpid(empId);
           
       }
    
       public Login_det updateLoginDet(Login_det updatedUser) {
           // Perform any necessary validation or business logic
           return repository.save(updatedUser);
       }

//    public String deleteLoginDet(String empId) {
//        repository.deleteById(empId);
//        return "Login Details removed!! " + empId;
//    }

//    public Login_det updateLoginDet(Login_det loginDet) {
//        Login_det existingLoginDet = repository.findByEmpid(loginDet.getEmpid()).orElse(null);
//        existingLoginDet.setEmail(loginDet.getEmail());
//        existingLoginDet.setPassword(loginDet.getPassword());
//        existingLoginDet.setRole(loginDet.getRole());
//        existingLoginDet.setFullname(loginDet.getFullname());
//        return repository.save(existingLoginDet);
//    }

    public List<LoginDto> getAllEmployeeDetails() {
        // TODO: Implement logic for fetching employee details
        return null;
    }

    public List<LoginDto> searchEmployees(String empId, String skillname, String domain, String subdomain,
            String proficiency) {
        // TODO: Implement logic for searching employees
        return null;
    }
    
    public void sendOtpService(String email) {
		String otp=generateOtp();
		
		//System.out.print(email);
		if (otp == null) 
		{
            throw new RuntimeException("Failed to generate OTP");
        }
		
		Login_det user = repository.findByEmail(email);
		if (user==null)
		{
			 user=new Login_det();
		}
		
		user.setEmail(email);
		
		user.setOtp(otp);
		repository.save(user);
		try {
			sendOtpToMail(email,otp);
			
		}catch(MessagingException e) {
			throw new RuntimeException("unable to send otp");
		}
		
	}
	public String generateOtp() {
		SecureRandom random=new SecureRandom();
		int otp= 100000 + random.nextInt(900000);
		return String.valueOf(otp);
	}
	
	public void sendOtpToMail(String email,String otp) throws MessagingException {
		MimeMessage mimeMessage=javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage);
		mimeMessageHelper.setTo(email);
		mimeMessageHelper.setSubject("Your OTP is:");
		mimeMessageHelper.setText(otp);
		javaMailSender.send(mimeMessage);
				
	}


	public boolean verifyOtp(String email, String otp) {
		Login_det user = repository.findByEmail(email);

		if (user != null && user.getOtp() != null && user.getOtp().equals(otp))
		 {
			 return true;
		 }
		return false;
	}

	
	public int resetPassword(Login_det user) {
		Login_det user1 = repository.findByEmail(user.getEmail());
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		if (user1==null) {
			return 1;
		}
		 if (user1.getOtp() .equals(user.getOtp())){
			 String password=encoder.encode(user.getPassword());
			 user1.setPassword(password);
			 repository.save(user1);
			 return 2;
		 }
		 return 3;
		 
	}
	
	    @Transactional
	    public void saveEmailAndOTP(VerifyOtpDTO verifyOtpDTO) {
	        String email = verifyOtpDTO.getEmail();
	        String otp = verifyOtpDTO.getOtp();

	        Login_det user = repository.findByEmail(email);

	        // Only save email and OTP if the user does not exist
	        if (user == null) {
	            user = new Login_det();
	            user.setEmail(email);
	            user.setOtp(otp);
	            repository.save(user);
	        }
	    }
	    

	    // Method to save partial user details to the database (without OTP and password)
	    public void savePartialDetails(Login_det loginDto) {
	    	System.out.println("savepartial detail");
	        // You need to implement the logic to interact with your database and save partial details
	        // For example, using a UserRepository
	        // userRepository.save(new User(loginDto.getEmpId(), loginDto.getFullName(), loginDto.getEmail()));
	    	Login_det us = new Login_det();
	        us.setEmpid(loginDto.getEmpid());
	        us.setFullname(loginDto.getFullname());
	        us.setEmail(loginDto.getEmail());
            us.setGender(loginDto.getGender());
	        // Save the entity to the database using the UserRepository
	        repository.save(us);
	    }

	    // Method to save complete user details to the database
	    public void saveUser(LoginDto loginDto) {
	        // You need to implement the logic to interact with your database and save complete user details
	        // For example, using a UserRepository
	        // userRepository.save(new User(loginDto.getEmpId(), loginDto.getFullName(), loginDto.getEmail(), loginDto.getPassword()));
//	 LoginDto user = new LoginDto(loginDto.getEmail(),loginDto.getEmpid(),  loginDto.getPassword(),loginDto.getRole(),loginDto.getFullname(),loginDto.getProject(),loginDto.getPro_desc(),loginDto.getDateFrom(),loginDto.getDateTo(),loginDto.getDesignation());
//	    	    public LoginDto(String email, String empid, String password, String role,String otp, String fullname, String project, String pro_desc, Date dateFrom, Date dateTo, String designation) {

	    	 
	    	 repository.save(new Login_det(loginDto.getEmpid(),loginDto.getEmail(),  loginDto.getPassword(),loginDto.getRole(),loginDto.getFullname(),loginDto.getProject(),loginDto.getPro_desc(),loginDto.getDateFrom(),loginDto.getDateTo(),loginDto.getOtp(),loginDto.getDesignation(),loginDto.getGender()));
//	    		public Login_det(String empid, String email, String password, String role, String fullname,String otp,String project, String pro_desc, Date dateFrom, Date dateTo, String designation) {
//
	    }
	    public boolean existsByEmpid(String empid) {
	        return repository.existsByEmpid(empid);
	    }
	 
	 
	    
	    
}

