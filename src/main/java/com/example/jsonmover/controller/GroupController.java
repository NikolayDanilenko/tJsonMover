package com.example.jsonmover.controller;


import com.example.jsonmover.dto.AddGroupRequestDto;
import com.example.jsonmover.dto.FindAllGroupsDto;
import com.example.jsonmover.dto.FindByIdGroupRequestDto;
import com.example.jsonmover.service.GroupService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/groups")
@Tag(name = "Group Controller", description = "API для управления группами университетов")
public class GroupController {


    private final GroupService groupService;


    @Operation(summary = "Создание новой группы", description = "Добавляет новую группу в университет")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Группа успешно создана", content = @Content),
            @ApiResponse(responseCode = "400", description = "Некорректный запрос", content = @Content)
    })
    @PostMapping()
    public ResponseEntity<Void> add(@RequestBody AddGroupRequestDto addGroupRequestDto) {
        groupService.addGroup(addGroupRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Получение группы по ID", description = "Возвращает группу университета с указанным ID, включая список студентов")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Группа найдена",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FindByIdGroupRequestDto.class))),
            @ApiResponse(responseCode = "404", description = "Группа не найдена", content = @Content)
    })
    @GetMapping(value = "/{groupId}")
    public ResponseEntity<FindByIdGroupRequestDto> findGroupById(
            @Parameter(description = "ID группы для поиска", required = true) @PathVariable Integer groupId) {
        FindByIdGroupRequestDto groupWithStudents = groupService.getGroupWithStudents(groupId);
        return ResponseEntity.ok(groupWithStudents);
    }

    @Operation(summary = "Получение списка всех групп", description = "Возвращает список всех групп университета")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Список групп успешно получен",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FindAllGroupsDto.class)))
    })
    @GetMapping()
    public ResponseEntity<List<FindAllGroupsDto>> findAllGroupsDto() {
        List<FindAllGroupsDto> list = groupService.findAllGroups();
        return ResponseEntity.ok(list);
    }
}

