package com.global.reposetory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.global.entity.Student;

@Repository
public interface StudentRepo  extends JpaRepository<Student, Long>{

}
