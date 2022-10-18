package com.gomezcamila.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gomezcamila.cms.model.Program;
import com.gomezcamila.cms.repository.ProgramRepository;

@Service
public class ProgramService {
	
	@Autowired
	private ProgramRepository programRepository;
	
	public List<Program> getAllPrograms(){
		
		return programRepository.findAll();
	}
	public Program getProgramById(Integer id) {
	
		return programRepository.findById(id).get();
	}
	public String getProgramNameById(Integer id) {
	
		Program program = this.getProgramById(id);
		return program.getProgramName();
	}
	public Integer getProgramIdByName(String name) {
		
		List<Program> programs = this.getAllPrograms();
		for(Program program : programs)
		{  
			String programName = program.getProgramName();
			if(programName.equalsIgnoreCase(name)) 
				return program.getProgramId();	
		}
		return -1;
	}
}
