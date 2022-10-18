package com.gomezcamila.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.gomezcamila.cms.model.Instructor;
import com.gomezcamila.cms.model.Program;
//import com.gomezcamila.cms.model.Program;
//import com.gomezcamila.cms.repository.InstructorRepository;
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

		/*
		 * //getProgramNames() returns a List of Program Names
		 * model.addAttribute("programNames",instructorService.getProgramNames());
		 */

		// Add program object to set program for instructor
		model.addAttribute("programList", instructorService.getAllPrograms());

		return "createInstructorForm";
	}
	@PostMapping("/instructors") 
	  public String saveInstructor
	  			(@ModelAttribute("instructor")Instructor instructor,
	  			@ModelAttribute("program")Program program) {
	  
	  System.out.println("This is passed in instructor: " + instructor); Instructor
	  newInstructor = instructorService.getInstructorById(instructor.getId());
	  
	  System.out.println("This is newInstructor: " + newInstructor);
	  System.out.println("This is passed in program: " + program);
	  System.out.println("This is passed in program ID: " +
	  program.getProgramId());
	  
	  
	  newInstructor.setProgram(instructorService.getProgramById(program.
	  getProgramId()));
	  
	  //set instructor's program id
	  instructorService.saveInstructor(newInstructor);
	  
	  //Show added instructor to main instructor page return
	  return "redirect:/instructors"; 
	  }
	// Get form to create new update
	@GetMapping("/instructors/update/{id}")
	public String updateInstructor(@PathVariable Long id, Model model) {

		model.addAttribute("instructor", instructorService.getInstructorById(id));
		// Add program object to set program for instructor
		model.addAttribute("programList", instructorService.getAllPrograms());

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
