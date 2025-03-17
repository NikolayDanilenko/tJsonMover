package com.example.jsonmover.controller;



import com.example.jsonmover.dto.AddGroupRequestDto;
import com.example.jsonmover.dto.FindAllGroupsDto;
import com.example.jsonmover.dto.FindByIdGroupRequestDto;
import com.example.jsonmover.entity.UniversityGroup;
import com.example.jsonmover.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/groups")
public class GroupController {


    private final GroupService groupService;


    @PostMapping
    public void add(@RequestBody AddGroupRequestDto addGroupRequestDto) {
        groupService.addGroup(addGroupRequestDto);
        System.out.println("Создано");
    }

    @GetMapping("/{groupId}")
    public FindByIdGroupRequestDto getGroupWithStudents(@PathVariable Integer groupId) {
        return groupService.getGroupWithStudents(groupId);
    }

    @GetMapping()
    public List<FindAllGroupsDto> findAllGroupsDto(){
        return groupService.findAllGroups();
    }
}


