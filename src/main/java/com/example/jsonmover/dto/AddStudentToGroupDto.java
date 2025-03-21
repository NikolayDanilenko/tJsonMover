package com.example.jsonmover.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Запрос на добавление студента в группу")
public class AddStudentToGroupDto {

    @Schema(description = "Полное имя студента", example = "Петров Петр Петрович")
    private String fullName;

    @Schema(description = "ID группы, в которую добавляется студент", example = "1")
    private Integer id;
}