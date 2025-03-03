package com.example.jsonmover.service;

import com.example.jsonmover.entity.Student;
import com.example.jsonmover.entity.UniversityGroup;
import com.example.jsonmover.repository.StudentRepository;
import com.example.jsonmover.repository.UniversityGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GroupService {

    @Autowired
    private UniversityGroupRepository universityGroupRepository;

    public UniversityGroup addUniversityGroup(UniversityGroup universityGroup) {
        if (universityGroup.getName() == null || universityGroup.getName().isEmpty()) {
            throw new RuntimeException("Имя группы не может быть пустым");
        }
        return universityGroupRepository.save(universityGroup);
    }

    public UniversityGroup findUniversityGroupById(int id) {
        return universityGroupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Группа не найдена"));
    }

    public List<GroupProjection> getAllGroupsWithStudentCount() {
        return universityGroupRepository.findAllGroupsWithStudentCount();
    }
}

