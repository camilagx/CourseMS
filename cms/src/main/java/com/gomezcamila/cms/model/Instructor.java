package com.gomezcamila.cms.model;

import javax.persistence.*;

@Entity
@Table(name="instructor")
public class Instructor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="instructor_id")
	private Long id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column
	private String status = "unassigned";
	
	@ManyToOne(targetEntity = Program.class,
			 cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="program_id")
	private Program program;

	public Instructor() {
	}
	
	public Instructor(String firstName, String lastName, String email, String status, Program program) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.status = status;
		this.program = program;
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

	public Program getProgram() {
		return this.program;
	}
	
	public void setProgram(Program program) {
		this.program = program;
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", status=" + status + ", program=" + program + "]";
	}
	
	
}
