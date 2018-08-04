package com.vrpowerz.ServeBetR.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Venkataraghavan Yanamandram
 *
 */

@Configuration
public class PasswordEncoder {
	
	public org.springframework.security.crypto.password.PasswordEncoder getOAuth2ClientPasswordEncoder(){
		return new BCryptPasswordEncoder(4);
	}
	
	public org.springframework.security.crypto.password.PasswordEncoder getUserPasswordEncoder(){
		return new BCryptPasswordEncoder(12);
	}

}
