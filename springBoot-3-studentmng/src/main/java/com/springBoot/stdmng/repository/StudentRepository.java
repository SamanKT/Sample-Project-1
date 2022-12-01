package com.springBoot.stdmng.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.stdmng.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
