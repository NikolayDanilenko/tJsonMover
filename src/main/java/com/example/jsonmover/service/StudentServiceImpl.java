package com.example.jsonmover.service;

import com.example.jsonmover.dto.AddGroupRequestDto;
import com.example.jsonmover.dto.AddStudentRequestDto;
import com.example.jsonmover.dto.AddStudentToGroupDto;
import com.example.jsonmover.dto.FindByIdGroupRequestDto;
import com.example.jsonmover.entity.Student;
import com.example.jsonmover.entity.UniversityGroup;
import com.example.jsonmover.repository.GroupRepository;
import com.example.jsonmover.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {


    private final StudentRepository studentRepository;

    private final GroupRepository groupRepository;


    @Override
    public void addStudent(AddStudentToGroupDto addStudentToGroupDto) {

        UniversityGroup group = groupRepository.findById(addStudentToGroupDto.getId())
                .orElseThrow(() -> new RuntimeException("Group not found"));

        String name = addStudentToGroupDto.getFullName();
        Student student = new Student();
        student.setName(name);
        student.setUniversityGroup(group);
        studentRepository.save(student);

    }
}
