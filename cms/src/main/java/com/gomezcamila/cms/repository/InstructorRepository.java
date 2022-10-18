package com.gomezcamila.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gomezcamila.cms.model.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {

}
