package com.gomezcamila.cms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gomezcamila.cms.model.Instructor;
import com.gomezcamila.cms.repository.InstructorRepository;
import com.gomezcamila.cms.utilities.ProgramNamesEnum;

@Service
public class InstructorService{

	@Autowired
	private InstructorRepository instructorRepository;

	public List<Instructor> getAllInstructor() {
		return instructorRepository.findAll();
	}
	
	public Instructor getInstructorById(Long id) {
		return instructorRepository.findById(id).get();
	}

	//implemented query from instructor repository
	public List<Instructor> getInstructorsByStatus(String status){
		return instructorRepository.getInstructorsByStatus(status);
	}
	
	//Will allow filtering of Instructors by program
	//implemented query from instructor repository
	public List<Instructor> getInstructorsByProgramName(String name){
		return instructorRepository.getInstructorsByProgramName(name);
	}
	
	//CREATE/SAVE
	public void saveInstructor(Instructor instructor) {
		instructorRepository.save(instructor);
	}
	
	public List<String> getProgramNames() {
		List<String> programNames = new ArrayList<>();
		
		for(ProgramNamesEnum name: ProgramNamesEnum.values()) {
			programNames.add(name.getProgamName());
		}
		return programNames;	
	}

	public Instructor updateInstructor(Instructor instructor) {
		return instructorRepository.save(instructor);
	}
	public Instructor deleteInstructorById(Long id) {
		Instructor instructorDeleted = instructorRepository.findById(id).get();
		instructorRepository.deleteById(id);
		
		return instructorDeleted;
	}
	//CUSTOM QUERIES
	//get Instructor by Program and Status. This query allows Cohort to be assigned to available Instructor w/ same program
	public List<Instructor> getInstructorsByProgAndStatus(String program, String status){
		return instructorRepository.getInstructorsByProgAndStatus(program, status);
	}
}

