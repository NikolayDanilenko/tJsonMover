package com.example.jsonmover.service;

import com.example.jsonmover.dto.AddGroupRequestDto;
import com.example.jsonmover.dto.AddStudentRequestDto;
import com.example.jsonmover.dto.FindAllGroupsDto;
import com.example.jsonmover.dto.FindByIdGroupRequestDto;
import com.example.jsonmover.entity.Student;
import com.example.jsonmover.entity.UniversityGroup;
import com.example.jsonmover.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {


    private final GroupRepository groupRepository;

    @Override
    public void addGroup(AddGroupRequestDto addGroupRequestDto) {

        String number = addGroupRequestDto.getNumber();
        UniversityGroup universityGroup = new UniversityGroup();
        universityGroup.setName(number);
        groupRepository.save(universityGroup);

    }

    @Override
    public FindByIdGroupRequestDto getGroupWithStudents(Integer groupId) {

        UniversityGroup group = groupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Group not found"));


        return new FindByIdGroupRequestDto(
                group.getName(),
                group.getStudents().stream()
                        .map(student -> new AddStudentRequestDto(student.getName()))
                        .collect(Collectors.toList())
        );
    }

    @Override
    public List<FindAllGroupsDto> findAllGroups() {
        List<UniversityGroup> groups = groupRepository.findAll();

        return groups.stream()
                .map(group-> {
                    FindAllGroupsDto findAllGroupsDto = new FindAllGroupsDto();
                    findAllGroupsDto.setName(group.getName());

                    List<Student> studentList = new ArrayList<>();
                    findAllGroupsDto.setStudentCount((group.getStudents() != null ? group.getStudents().size() : 0));

                    return findAllGroupsDto;
                })
                .collect(Collectors.toList());
    }
}

