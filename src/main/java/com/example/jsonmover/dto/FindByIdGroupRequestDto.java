package com.example.jsonmover.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Информация о группе с указанием списка студентов")
public class FindByIdGroupRequestDto {

    @Schema(description = "ID группы", example = "1")
    private int id;

    @Schema(description = "Название группы", example = "00-**")
    private String name;

    @Schema(description = "Список студентов в группе")
    private List<AddStudentRequestDto> addStudentRequestDtoList;

    public FindByIdGroupRequestDto(String name, List<AddStudentRequestDto> addStudentRequestDtoList) {
        this.name = name;
        this.addStudentRequestDtoList = addStudentRequestDtoList;
    }
}