package com.gomezcamila.cms.model;

import javax.persistence.*;

@Entity
@Table(name="student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="student_id")
	private Long studentId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@OneToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			  CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="cohort_id")
	private Cohort cohort;

	public Student() {
	}

	public Student(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
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

	public Cohort getCohort() {
		return cohort;
	}

	public void setCohort(Cohort cohort) {
		this.cohort = cohort;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName + ", cohort="
				+ cohort + "]";
	}
	
}
