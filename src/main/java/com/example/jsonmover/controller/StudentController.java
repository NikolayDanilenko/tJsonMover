package com.example.jsonmover.controller;

import com.example.jsonmover.dto.AddGroupRequestDto;
import com.example.jsonmover.dto.AddStudentRequestDto;
import com.example.jsonmover.dto.AddStudentToGroupDto;
import com.example.jsonmover.entity.Student;
import com.example.jsonmover.service.StudentService;
import com.example.jsonmover.service.StudentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @PostMapping()
    public void addStudent(@RequestBody AddStudentToGroupDto addStudentToGroupDto){
            studentService.addStudent(addStudentToGroupDto);
            System.out.println("Создано");
        }
    }


