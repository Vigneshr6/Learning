package com.vignesh.springboot_playground.model;

import org.springframework.security.core.GrantedAuthority;

public enum AuthenticationRoles implements GrantedAuthority {

	ROLE_USER, ROLE_ADMIN, ROLE_BLOCKED;

	@Override
	public String getAuthority() {
		return name();
	}
}
