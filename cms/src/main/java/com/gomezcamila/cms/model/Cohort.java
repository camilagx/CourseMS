package com.gomezcamila.cms.model;

import javax.persistence.*;

@Entity
@Table(name="cohort")
public class Cohort {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cohort_id")
	private Long cohortId;
	
	@Column(name="start_date", nullable=false)
	private String startDate;
	
	@Column(name="end_date", nullable=false)
	private String endDate;
	
	@Column(name="program_name")
	private String programName;
	
	@OneToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			  CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="instructor_id")
	private Instructor instructor;
	
	
	public Cohort() {
	}

	public Cohort(String startDate, String endDate,String programName){
		this.startDate = startDate;
		this.endDate = endDate;
		this.programName = programName;
	}

	public Long getCohortId() {
		return cohortId;
	}

	public void setCohortId(Long cohortId) {
		this.cohortId = cohortId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getProgramName(){
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor= instructor;
	}

	@Override
	public String toString() {
		return "Cohort [cohortId=" + cohortId + ", startDate=" + startDate + ", endDate=" + endDate + ", programName="
				+ programName + ", instructorId=" + instructor + "]";
	}	
	
}
