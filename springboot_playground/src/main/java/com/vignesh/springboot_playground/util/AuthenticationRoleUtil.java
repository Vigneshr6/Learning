package com.vignesh.springboot_playground.util;

import com.vignesh.springboot_playground.model.AuthenticationRoles;

public class AuthenticationRoleUtil {
	public static AuthenticationRoles getRole(String rolename) {
		for (AuthenticationRoles role : AuthenticationRoles.values()) {
			if (role.name().equals(rolename))
				return role;
		}
		return AuthenticationRoles.ROLE_BLOCKED;
	}
}
