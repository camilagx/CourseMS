package com.gomezcamila.cms.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.gomezcamila.cms.model.Cohort;

public interface CohortRepository extends JpaRepository<Cohort, Long>{

	
	@Query("FROM Cohort WHERE instructor_id IS NULL")
	public List<Cohort> getUnassignedCohorts();
	
	@Query("FROM Cohort WHERE status = ?1")
	public List<Cohort> getCohortsByStatus(String status);

}
