package com.hms.HmsRestProject.dto;

import java.sql.Date;

public class PatientRegistrationDto {
	private String id;
	private String firstName;
	private String lastName;
	private String password;
	private Date dateOfBith;
	private String email;
	public String diseaseCategory;
	public int role;

	public PatientRegistrationDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PatientRegistrationDto(String id, String firstName, String lastName, String password, Date dateOfBith,
			String email, String diseaseCategory, int role) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.dateOfBith = dateOfBith;
		this.email = email;
		this.diseaseCategory = diseaseCategory;
		this.role = role;
	}

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

	public String getDiseaseCategory() {
		return diseaseCategory;
	}

	public void setDiseaseCategory(String diseaseCategory) {
		this.diseaseCategory = diseaseCategory;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

}
