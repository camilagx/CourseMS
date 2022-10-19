package com.gomezcamila.cms;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gomezcamila.cms.model.Instructor;
import com.gomezcamila.cms.repository.InstructorRepository;

@SpringBootTest(classes = CmsApplication.class)
public class InstructorServiceTest {
	
	@Autowired
	InstructorRepository instructorRepository;
	
	//Test custom Query methods
	//Tests if instructors from resultset have 'unassigned' status
	@Test
	void getUnassignedInstructorsTest(){
		
		//given
		List<Instructor> instructors = 
				List.of(new Instructor("James","Lopez","j.lopez@email.com","unassigned","IT Support"),
						new Instructor("Timothy","Holland","t.holland@email.com","assigned","UX Design"),
						new Instructor("Julianna","Phillips","j.phillips@email.com","unassigned","Software Engineering"),
						new Instructor("Julianna","Phillips","j.phillips@email.com","assigned","Data Analytics"));
		
		//when
		String expectedInstructorStatus1 = instructors.get(0).getStatus();
		String expectedInstructorStatus2 = instructors.get(2).getStatus();
		String actualInstructorStatus1 = instructorRepository.getUnassignedInstructors().get(0).getStatus();
		String actualInstructorStatus2 = instructorRepository.getUnassignedInstructors().get(1).getStatus();
		
		//then
		Assertions.assertEquals(expectedInstructorStatus1, actualInstructorStatus1 );
		Assertions.assertEquals(expectedInstructorStatus2, actualInstructorStatus2);
	}
	
	@Test
	void getInstructorsByProgramNameTest(){
		
		List<Instructor> instructors = instructorRepository.getInstructorsByProgramName("Software Engineering");
	
		Assertions.assertNotNull(instructors);
	}
	
	//when
	
	
}
