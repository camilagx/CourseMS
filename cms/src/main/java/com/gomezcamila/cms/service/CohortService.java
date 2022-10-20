package com.gomezcamila.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gomezcamila.cms.model.Cohort;
import com.gomezcamila.cms.repository.CohortRepository;

@Service
public class CohortService {
	@Autowired
	CohortRepository cohortRepository;
	
	//READ ONLY - Get All cohorts
	public List<Cohort> getAllCohorts(){
		return cohortRepository.findAll();
	}
	//READ ONLY - Get Cohort by ID
	public Cohort getCohortById(Long id){
		return cohortRepository.findById(id).get();
	}

	//Create
	public Cohort saveCohort(Cohort cohort) {
		Cohort newCohort = cohortRepository.findById(cohort.getCohortId()).get();
		cohortRepository.save(newCohort);
		
		return newCohort;
	}
	//UPDATE
	public Cohort updateCohort(Cohort cohort) {
		Cohort updatedCohort = cohortRepository.findById(cohort.getCohortId()).get();
		cohortRepository.save(updatedCohort);
		
		return updatedCohort;
	}
	//DELETE
	public Cohort deleteCohortById(Long id) {
		Cohort cohortDeleted = cohortRepository.findById(id).get();
		cohortRepository.deleteById(id);
		
		return cohortDeleted;
	}
	
	//Custom Queries. Get Unassigned cohorts
	public List<Cohort> getUnassignedCohorts(){
		return cohortRepository.getUnassignedCohorts();
	}
	public List<Cohort> getCohortsByStatus(String status){
		return cohortRepository.getCohortsByStatus(status);
	}
}
