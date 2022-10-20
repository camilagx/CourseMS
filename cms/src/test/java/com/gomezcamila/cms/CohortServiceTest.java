package com.gomezcamila.cms;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gomezcamila.cms.model.Cohort;
import com.gomezcamila.cms.service.CohortService;

@SpringBootTest(classes = CmsApplication.class)
public class CohortServiceTest {

	@Autowired
	CohortService cohortService;

	// Test custom Query methods

	@Test
	void getAllCohortsTest() {
		Assertions.assertNotNull(cohortService.getAllCohorts());
	}

	@Test 
	void getUnassignedCohortsTest(){
		 Assertions.assertNotNull(cohortService.getUnassignedCohorts());
	}
	
	@Test
	void getCohortsByStatusTest() {
		String expectedValue = "unassigned";
		
		Cohort tempCohort = cohortService.getCohortsByStatus("unassigned").get(0);
		String actualValue = tempCohort.getStatus();
		
		Assertions.assertEquals(expectedValue, actualValue);
	}
}
