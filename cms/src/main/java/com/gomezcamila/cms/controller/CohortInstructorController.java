package com.gomezcamila.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gomezcamila.cms.model.Cohort;
import com.gomezcamila.cms.model.Instructor;
import com.gomezcamila.cms.service.CohortService;
import com.gomezcamila.cms.service.InstructorService;
import com.gomezcamila.cms.utilities.TypeOfStatusEnum;

@Controller
public class CohortInstructorController {

	@Autowired
	CohortService cohortService;
	
	@Autowired
	InstructorService instructorService;
	
	@GetMapping("/cohortInstructor")
	public String getCohortInfo(Model model) {
		
		model.addAttribute("cohorts", cohortService.getAllCohorts());
		model.addAttribute("assigned",TypeOfStatusEnum.ASSIGNED.getStatus());
		model.addAttribute("unassigned",TypeOfStatusEnum.UNASSIGNED.getStatus());
		
		return "cohortInstructorPage";
	}
	
	@GetMapping("/cohortInstructor/update/{id}")
	public String getCohortInstructorForm(@PathVariable("id") Long id, Model model) {
		Cohort cohortToAssign = cohortService.getCohortById(id);
		String cohortProgram = cohortToAssign.getProgramName();

		List<Instructor> instructorList = instructorService.
				getInstructorsByProgAndStatus(cohortProgram,TypeOfStatusEnum.UNASSIGNED.getStatus());
		
		model.addAttribute("cohortToAssign",cohortToAssign);
		model.addAttribute("instructorList",instructorList);
		
		return "assignCohortForm"; 
	}
	//Update/Assign
	@PostMapping("/cohortInstructor/assign/{id}")
	public String assignCohortInstructor(@PathVariable("id") Long id, 
						@ModelAttribute("cohortToAssign") Cohort cohort, 
						Model model) {
		
		// get Cohort from database by Id
		Cohort cohortToAssign = cohortService.getCohortById(id);
		Instructor chosenInstructor = cohort.getInstructor();
		
		//Set assigned intructor to cohort
		cohortToAssign.setInstructor(chosenInstructor);
		
		//update Instructor & Cohort status
		chosenInstructor.setStatus(TypeOfStatusEnum.ASSIGNED.getStatus());
		cohortToAssign.setStatus(TypeOfStatusEnum.ASSIGNED.getStatus());

		// Save the updates into database
		instructorService.updateInstructor(chosenInstructor);
		cohortService.updateCohort(cohortToAssign);

		return "redirect:/cohortInstructor";
	}
}
