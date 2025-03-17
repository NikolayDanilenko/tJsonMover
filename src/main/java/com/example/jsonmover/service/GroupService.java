package com.example.jsonmover.service;


import com.example.jsonmover.dto.AddGroupRequestDto;
import com.example.jsonmover.dto.FindAllGroupsDto;
import com.example.jsonmover.dto.FindByIdGroupRequestDto;

import java.util.List;


public interface GroupService {

    void addGroup(AddGroupRequestDto addGroupRequestDto);

    FindByIdGroupRequestDto getGroupWithStudents(Integer groupId);

    List<FindAllGroupsDto> findAllGroups();

}
