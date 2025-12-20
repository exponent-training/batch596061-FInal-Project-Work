package com.FinMediNexus.Entity;

import java.sql.Date;
import java.util.Collection;
import java.util.Collections;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.FinMediNexus.Enum.Role;
import com.FinMediNexus.security.CustomerUserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import lombok.NoArgsConstructor;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;


@Entity
@Data
@Slf4j
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements UserDetails,CustomerUserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "name", nullable = false, length = 100)
	@NotBlank(message = "Name is required")
	@Size(min = 3, max = 100, message = "Name must be 3-100 characters")
	private String name;

	@Column(name = "email", unique = true, nullable = false, length = 150)
	@Email(message = "Invalid email format")
	@NotBlank(message = "Email is required")
	private String email;

	@Column(name = "phno")
	@NotNull(message = "Phone number required")
	@Digits(integer = 10, fraction = 0, message = "Phone number must be 10 digits")
	private Long phno;

	@Column(name = "pwd", nullable = false)
	@NotBlank(message = "Password is required")
	@Size(min = 6, message = "Password must be at least 6 characters")
	private String pwd;

	@Column(name = "pwd_updated")
	private String pwdUpdated;

	@Enumerated(EnumType.STRING)
	@NotNull(message = "Role is required")
	@Column(name = "role", nullable = false, length = 20)
	private Role role;

	@CreationTimestamp
	@Column(name = "created_date", updatable = false)
	private Date createdDate;

	@UpdateTimestamp
	@Column(name = "updated_date")
	private Date updatedDate;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		log.debug("getAuthorities()");
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role.name().toString());
		return Collections.singletonList(authority);
	}

	@Override
	public boolean isAccountNonExpired() {
		log.debug("isAccountNonExpired()");
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		log.debug("isAccountNonLocked()");
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		log.debug("isCredentialsNonExpired()");
		return true;
	}

	@Override
	public boolean isEnabled() {
		log.debug("isEnabled()");
		return true;
	}

	@Override
	public String getPassword() {
		return this.pwd;
	}

	@Override
	public String getUsername() {
		return this.email;
	}
	
	 @Override
	    public String getEmail() {
	        return this.email;
	    }

}
