package com.vignesh.springboot_playground.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.vignesh.springboot_playground.util.AuthenticationRoleUtil;

@Entity
@Table(name = "user")
public class User {
	private long id;
	private String username;
	private String password;
	private LocalDate dob;
//	@Enumerated(EnumType.STRING)
	private List<AuthenticationRoles> grants = new ArrayList<AuthenticationRoles>();
	private String metaRoles;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Transient
	public List<AuthenticationRoles> getGrants() {
		return grants;
	}

	public void setGrants(List<AuthenticationRoles> grants) {
		this.grants = grants;
	}

	@Column(name = "roles")
	public String getMetaRoles() {
		return metaRoles;
	}

	public void setMetaRoles(String metaRoles) {
		System.out.println("setMetaRoles");
		this.metaRoles = metaRoles;
		Arrays.asList(metaRoles.split(",")).stream().forEach(rolename -> {
			System.out.println("addRole : " + rolename);
			getGrants().add(AuthenticationRoleUtil.getRole(rolename));
		});
	}
	
	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", dob=" + dob + ", grants="
				+ grants + ", metaRoles=" + metaRoles + "]";
	}

}
