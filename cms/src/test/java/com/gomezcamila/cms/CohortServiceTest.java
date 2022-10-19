package com.gomezcamila.cms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gomezcamila.cms.service.CohortService;


@SpringBootTest(classes = CmsApplication.class)
public class CohortServiceTest {
	
	@Autowired
	CohortService cohortService;
	
	//Test custom Query methods
	
	@Test
	void getAllCohortsTest(){
		
		Assertions.assertNotNull(cohortService.getAllCohorts());

	}

	
}
