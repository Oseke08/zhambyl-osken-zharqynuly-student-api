package com.zhambyl.studentapi.repository;

import com.zhambyl.studentapi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
