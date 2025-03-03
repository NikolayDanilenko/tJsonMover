package com.example.jsonmover.controller;

import com.example.jsonmover.entity.Student;
import com.example.jsonmover.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @PutMapping("/{studentId}/add/{groupId}")
    public Student addStudentToGroup(
            @PathVariable int studentId,
            @PathVariable int groupId
    ) {
        return studentService.updateStudentToGroup(studentId, groupId);
    }

    @PostMapping("{groupId}")
    public Student addStudentToGroup(
            @RequestBody Student student,
            @PathVariable int groupId
    ) {
        return studentService.saveStudentWithGroup(student,groupId);
    }

    @GetMapping
    public List<Student> getAllStudent(){
      return studentService.findAllStudent();
    }
}
