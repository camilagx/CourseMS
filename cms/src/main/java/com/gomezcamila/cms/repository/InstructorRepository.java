package com.gomezcamila.cms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.gomezcamila.cms.model.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {

	//Customer query
	@Query("FROM Instructor WHERE STATUS = ?1")
	public List<Instructor> getInstructorsByStatus(String status);
	
	@Query("FROM Instructor WHERE programName = ?1")
	public List<Instructor> getInstructorsByProgramName(String name);
	
	@Query("FROM Instructor WHERE programName = ?1 AND STATUS = ?2")
	public List<Instructor> getInstructorsByProgAndStatus(String program, String status);
}
