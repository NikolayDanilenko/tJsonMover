package com.example.jsonmover.service;


import com.example.jsonmover.entity.Student;
import com.example.jsonmover.entity.UniversityGroup;
import com.example.jsonmover.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private GroupService groupService;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudentToGroup(int studentId, int groupId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Студент не найден"));
        UniversityGroup group = groupService.findUniversityGroupById(groupId);
        student.setUniversityGroup(group);
        return studentRepository.save(student);
    }

    public Student saveStudentWithGroup(Student student, int groupId) {
        UniversityGroup group = groupService.findUniversityGroupById(groupId);
        student.setUniversityGroup(group);
        return studentRepository.save(student);
    }

    public List<Student> findAllStudent(){
        return studentRepository.findAll();
    }
}


