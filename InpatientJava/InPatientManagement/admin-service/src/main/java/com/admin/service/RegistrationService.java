package com.admin.service;

import java.sql.Timestamp;

import com.admin.bean.LoginBean;
import com.admin.bean.RegistrationBean;
import com.admin.entity.RegistrationForm;

public interface RegistrationService {

	RegistrationForm validateLogin(LoginBean loginBean);

	RegistrationForm forgetPassword(String email);

	void sendOtpEmail(String toEmail, String otp);

	String generateOtp();

	void saveOtp(String email, String otp, Timestamp expirationTime);

	boolean verifyOtp(String email, String enteredOtp);

	RegistrationForm updatePassword(String email, String password);

	RegistrationBean saveRegistration(RegistrationBean registrationBean);
}
