package com.gomezcamila.cms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.gomezcamila.cms.model.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {

	
	@Query("FROM Instructor WHERE STATUS = 'unassigned'")
	public List<Instructor> getUnassignedInstructors();
	
	@Query("FROM Instructor WHERE programName = ?1")
	public List<Instructor> getInstructorsByProgramName(String name);
	
}
