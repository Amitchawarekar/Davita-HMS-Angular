package com.hms.HmsRestProject.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Master {
 
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String password;
	@Column(name = "DOB")
	private Date dateOfBith;
	private String email;
 
	@ManyToOne
	//@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "roleId")
	private Roles role;
 
	@ManyToOne
	@JoinColumn(name = "diseaseCategoryId")
	private DiseaseCategory diseaseCategory;
 
	public Master() {
		// TODO Auto-generated constructor stub
	}
 
	public Master(String id, String firstName, String lastName, String password, Date dateOfBith, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.dateOfBith = dateOfBith;
		this.email = email;
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
 
	public Roles getRoles() {
		return role;
	}
 
	public void setRole(Roles role) {
		this.role = role;
	}
 
	public void setDiseaseCategory(DiseaseCategory diseaseCategory) {
		this.diseaseCategory = diseaseCategory;
	}
 
	public DiseaseCategory getDiseaseCategory() {
		return diseaseCategory;
	}
 
	public String rolename() {
		return role.getRoleName();
	}
 
	@Override
	public String toString() {
		return "Master [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
				+ ", dateOfBith=" + dateOfBith + ", email=" + email + ", role=" + role + ", diseaseCategory="
				+ diseaseCategory + "]";
	}
 
}


