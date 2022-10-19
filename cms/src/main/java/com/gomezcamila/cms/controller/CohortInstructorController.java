package com.gomezcamila.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gomezcamila.cms.service.CohortService;

@Controller
public class CohortInstructorController {

	@Autowired
	CohortService cohortService;
	
	@GetMapping("/cohortInstructor")
	public String getCohortInstructorPage() {
		return "cohortInstructorPage";
	}
	@GetMapping("/cohortInstructor")
	public String getCohortInfo(Model model) {
		
		model.addAttribute("cohorts", cohortService.getAllCohorts());
		return  "cohortInstructorPage";
	}
}
