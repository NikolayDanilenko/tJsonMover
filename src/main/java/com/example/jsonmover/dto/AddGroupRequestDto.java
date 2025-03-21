package com.example.jsonmover.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Запрос на добавление новый группы")
public class AddGroupRequestDto {


    @Schema(description = "Номер группы", example = "00-**")
    private String number;
    
}
