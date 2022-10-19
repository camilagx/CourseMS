package com.gomezcamila.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gomezcamila.cms.model.Cohort;

public interface CohortRepository extends JpaRepository<Cohort, Long> {

	//@Query("FROM cohort ORDER BY startDate ASC")
 
}
