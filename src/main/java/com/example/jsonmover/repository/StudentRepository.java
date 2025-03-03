package com.example.jsonmover.repository;

import com.example.jsonmover.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface StudentRepository extends JpaRepository<Student, Integer> {

}
