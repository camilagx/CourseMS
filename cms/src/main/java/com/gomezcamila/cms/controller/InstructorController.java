package com.gomezcamila.cms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.gomezcamila.cms.model.Instructor;
import com.gomezcamila.cms.service.InstructorService;

@Controller
public class InstructorController {

	@Autowired
	private InstructorService instructorService;

	// Gets all instructors & return model and view
	@GetMapping("/instructors")
	public String listInstructors(Model model) {

		model.addAttribute("instructors", instructorService.getAllInstructor());

		return "instructorList";
	}

	@GetMapping("/instructors/new")
	public String createInstructorForm(Model model) {

		// create Instructor object and store user input
		model.addAttribute("instructor", new Instructor());

		//Get list of programs avaialble
		model.addAttribute("programList", instructorService.getProgramNames());

		return "createInstructorForm";
	}
	@PostMapping("/instructors") 
	public String saveInstructor
	  			(@Valid Instructor instructor, BindingResult result) {
	  
	  if(result.hasErrors())
			return "createInstructorForm";
	  //set instructor's program id
	  instructorService.saveInstructor(instructor);
	  
	  //Show added instructor to main instructor page return
	  return "redirect:/instructors"; 
	  }
	// Get form to create new update
	@GetMapping("/instructors/update/{id}")
	public String updateInstructor(@PathVariable Long id, Model model) {

		model.addAttribute("instructor", instructorService.getInstructorById(id));
		// Add program object to set program for instructor
		model.addAttribute("programList", instructorService.getProgramNames());

		return "updateInstructor";
	}

	// Handle for Instructor updates
	@PostMapping("/instructors/{id}")
	public String updateInstructor(@PathVariable Long id, @ModelAttribute("instructor") Instructor instructor,
			Model model) {
		// get Instructor from database by Id
		Instructor currentInstructor = instructorService.getInstructorById(id);
		System.out.println(currentInstructor);
		currentInstructor.setId(instructor.getId());
		currentInstructor.setFirstName(instructor.getFirstName());
		currentInstructor.setLastName(instructor.getLastName());
		currentInstructor.setEmail(instructor.getEmail());

		// Save the updates into database
		instructorService.updateInstructor(currentInstructor);

		return "redirect:/instructors";
	}

	@GetMapping("/instructors/{id}")
	public String deleteInstructor(@PathVariable("id") Long id) {
		instructorService.deleteInstructorById(id);

		return "redirect:/instructors";
	}
}
