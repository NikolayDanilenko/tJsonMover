package com.example.jsonmover.controller;

import com.example.jsonmover.dto.AddStudentToGroupDto;
import com.example.jsonmover.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
@Tag(name = "Student Controller", description = "API для управления студентами")
public class StudentController {

    private final StudentService studentService;

    @Operation(summary = "Добавление студента в группу", description = "Добавляет нового студента в указанную группу университета")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Студент успешно добавлен в группу", content = @Content),
            @ApiResponse(responseCode = "400", description = "Некорректный запрос", content = @Content),
            @ApiResponse(responseCode = "404", description = "Группа не найдена", content = @Content)
    })
    @PostMapping()
    public ResponseEntity<Void> addStudent(@RequestBody AddStudentToGroupDto addStudentToGroupDto) {
        studentService.addStudent(addStudentToGroupDto);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }
}