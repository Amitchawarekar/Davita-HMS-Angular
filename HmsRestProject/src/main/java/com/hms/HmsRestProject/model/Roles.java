package com.hms.HmsRestProject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Roles {

	@Id
	private int roleId;
	private String roleName;

	public int getRoleId() {
		return roleId;
	}
	public Roles() {

	}
	public Roles(int roleId, String roleName) {

		this.roleId = roleId;
		this.roleName = roleName;
	}

	public String getRoleName() {
		return roleName;
	}

}
