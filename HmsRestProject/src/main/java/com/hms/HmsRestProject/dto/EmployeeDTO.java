package com.hms.HmsRestProject.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class EmployeeDTO {
	private String id;
	private String firstName;
	private String lastName;
	private String password;
	private Date dateOfBith;
	private String email;
	private String roleName;
	private String diseaseCategoryName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateOfBith() {
		return dateOfBith;
	}

	public void setDateOfBith(Date dateOfBith) {
		this.dateOfBith = dateOfBith;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDiseaseCategoryName() {
		return diseaseCategoryName;
	}

	public void setDiseaseCategoryName(String diseaseCategoryName) {
		this.diseaseCategoryName = diseaseCategoryName;
	}

	public EmployeeDTO(String id, String firstName, String lastName, String password, Date dateOfBith, String email,
			String roleName, String diseaseCategoryName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.dateOfBith = dateOfBith;
		this.email = email;
		this.roleName = roleName;
		this.diseaseCategoryName = diseaseCategoryName;
	}

	public EmployeeDTO() {

	}

	@Override
	public String toString() {
		return "EmployeeDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", password="
				+ password + ", dateOfBith=" + dateOfBith + ", email=" + email + ", roleName=" + roleName
				+ ", diseaseCategoryName=" + diseaseCategoryName + "]";
	}

}
