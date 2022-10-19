package com.gomezcamila.cms.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;



@Entity
@Table(name="instructor")
public class Instructor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="instructor_id")
	private Long id;
	
	@NotBlank(message="First name cannot be blank")
	@Column(name="first_name")
	private String firstName;
	
	@NotBlank(message="Last name cannot be blank")
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column
	private String status = "unassigned";
	
	@NotBlank(message="Program must be selected")
	@Column(name="program_name")
	private String programName;
	
	public Instructor() {
	}

	public Instructor(String firstName, String lastName, String email, String status, String programName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.status = status;
		this.programName = programName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	@Override
	public String toString() {
		return "instructorId" + id + "firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", status=" + status + ", programName=" + programName + "]";
	}
	
	
	
}
