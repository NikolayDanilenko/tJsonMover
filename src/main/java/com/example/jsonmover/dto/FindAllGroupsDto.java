package com.example.jsonmover.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Информация о группе для отображения в списке")
public class FindAllGroupsDto {

    @Schema(description = "Название группы", example = "00-**")
    private String name;

    @Schema(description = "Количество студентов в группе", example = "25")
    private int studentCount;
}