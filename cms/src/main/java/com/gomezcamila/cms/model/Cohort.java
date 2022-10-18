package com.gomezcamila.cms.model;


import java.util.Set;

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
	
	@Column
	private String status = "unassigned";
	
	@ManyToMany(mappedBy="cohorts")
	private Set<Program> program;

	public Cohort() {
	}

	public Cohort(Long cohortId, String startDate, String endDate, String status, Set<Program> program) {
		this.cohortId = cohortId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.program = program;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<Program> getProgram() {
		return program;
	}

	public void setProgram(Set<Program> program) {
		this.program = program;
	}

	@Override
	public String toString() {
		return "Cohort [cohortId=" + cohortId + ", startDate=" + startDate + ", endDate=" + endDate + ", status="
				+ status + ", program=" + program + "]";
	}
	
}
