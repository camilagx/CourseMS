package com.gomezcamila.cms.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gomezcamila.cms.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}

