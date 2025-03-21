package com.example.jsonmover.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Запрос на добавление нового студента")
public class AddStudentRequestDto {

   @Schema(description = "Полное имя студента", example = "Иванов Иван Ивановыч")
   private String fullName;

}