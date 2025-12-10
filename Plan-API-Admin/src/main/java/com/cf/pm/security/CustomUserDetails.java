package com.cf.pm.security;

import org.springframework.security.core.userdetails.UserDetails;

public interface CustomUserDetails extends UserDetails {
	String getEmail();
}
