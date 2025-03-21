package com.example.jsonmover.service;

import com.example.jsonmover.dto.AddGroupRequestDto;
import com.example.jsonmover.dto.AddStudentRequestDto;
import com.example.jsonmover.dto.AddStudentToGroupDto;
import com.example.jsonmover.dto.FindByIdGroupRequestDto;
import com.example.jsonmover.entity.Student;
import com.example.jsonmover.entity.UniversityGroup;
import com.example.jsonmover.error.NotFoundException;
import com.example.jsonmover.repository.GroupRepository;
import com.example.jsonmover.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentServiceImpl implements StudentService {


    private final StudentRepository studentRepository;

    private final GroupRepository groupRepository;


    @Override
    public void addStudent(AddStudentToGroupDto addStudentToGroupDto) {
        log.info("start method addStudent with number {}", addStudentToGroupDto);
        UniversityGroup group = groupRepository.findById(addStudentToGroupDto.getId())
                .orElseThrow(() -> new NotFoundException("Group not found " + addStudentToGroupDto.getId()));

        String name = addStudentToGroupDto.getFullName();
        Student student = new Student();
        student.setName(name);
        student.setUniversityGroup(group);
        studentRepository.save(student);

    }
}
