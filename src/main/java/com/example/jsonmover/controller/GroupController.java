package com.example.jsonmover.controller;



import com.example.jsonmover.entity.Student;
import com.example.jsonmover.entity.UniversityGroup;
import com.example.jsonmover.service.GroupProjection;
import com.example.jsonmover.service.GroupService;
import com.example.jsonmover.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {


    @Autowired
    private GroupService groupService;


    @PostMapping
    public UniversityGroup addUniversityGroup(@RequestBody UniversityGroup universityGroup) {
        return groupService.addUniversityGroup(universityGroup);
    }


    @GetMapping
    public List<GroupProjection> getAllGroups() {
        return groupService.getAllGroupsWithStudentCount();
    }

}

