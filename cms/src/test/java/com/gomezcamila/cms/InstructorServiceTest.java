package com.gomezcamila.cms;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gomezcamila.cms.model.Instructor;
import com.gomezcamila.cms.repository.InstructorRepository;
import com.gomezcamila.cms.utilities.ProgramNamesEnum;
import com.gomezcamila.cms.utilities.TypeOfStatusEnum;

@SpringBootTest(classes = CmsApplication.class)
public class InstructorServiceTest {
	
	@Autowired
	InstructorRepository instructorRepository;
	
	//Test custom Query methods
	//Tests if instructors from resultset have 'unassigned' status
	@Test
	void getInstructorsByStatusTest(){
		
		//given
		List<Instructor> instructors = 
				List.of(new Instructor("James","Lopez","j.lopez@email.com","unassigned","IT Support"),
						new Instructor("Timothy","Holland","t.holland@email.com","assigned","UX Design"),
						new Instructor("Julianna","Phillips","j.phillips@email.com","unassigned","Software Engineering"),
						new Instructor("Julianna","Phillips","j.phillips@email.com","assigned","Data Analytics"));
		
		//when
		String expectedInstructorStatus1 = instructors.get(0).getStatus();
		String expectedInstructorStatus2 = instructors.get(2).getStatus();
		
		String status = TypeOfStatusEnum.UNASSIGNED.getStatus();
		String actualInstructorStatus1 = instructorRepository.getInstructorsByStatus(status).get(0).getStatus();
		String actualInstructorStatus2 = instructorRepository.getInstructorsByStatus(status).get(1).getStatus();
		
		//then
		Assertions.assertEquals(expectedInstructorStatus1, actualInstructorStatus1 );
		Assertions.assertEquals(expectedInstructorStatus2, actualInstructorStatus2);
	}
	
	@Test
	void getInstructorsByProgramNameTest(){
		
		List<Instructor> instructors = instructorRepository.getInstructorsByProgramName("Software Engineering");
	
		Assertions.assertNotNull(instructors);
	}
	
	@Test
	void getInstructorsByProgAndStatusTest(){
		
		//given
		String program = ProgramNamesEnum.UX_DESIGN.getProgamName();
		String status = TypeOfStatusEnum.UNASSIGNED.getStatus();
		
		//when
		Instructor instructor = instructorRepository
								.getInstructorsByProgAndStatus(program, status).get(0);
		
		String actualProgram = instructor.getProgramName();		
		String actualStatus = instructor.getStatus();		
		
		
		//then
		Assertions.assertEquals(program,actualProgram);
		Assertions.assertEquals(status,actualStatus);
		
	}
	
	
}
