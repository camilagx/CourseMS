package com.gomezcamila.cms.model;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="program")
public class Program {
	@Id
	@Column(name="program_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer programId;
	
	@Column(name="program_name")
	private String programName;
	
	@ManyToMany(targetEntity = Cohort.class)
	 @JoinTable(name = "program_cohort",
     joinColumns = { @JoinColumn(name = "program_id") },
     inverseJoinColumns = { @JoinColumn(name = "cohort_id") })
	private Set<Cohort> cohorts;
	
	public Program() {
	}

	public Program(Integer programId, String programName, Set<Cohort> cohorts) {
		this.programId = programId;
		this.programName = programName;
		this.cohorts = cohorts;
	}

	public Integer getProgramId() {
		return programId;
	}
	
	public void setProgramId(Integer id) {
		this.programId = id;
	}
	
	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public Set<Cohort> getCohorts() {
		return cohorts;
	}

	public void setCohorts(Set<Cohort> cohorts) {
		this.cohorts = cohorts;
	}

	@Override
	public String toString() {
		return programName;
	}
}
