package com.example.jsonmover.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class FindByIdGroupRequestDto {

    private int id;
    private String name;
    private List<AddStudentRequestDto> addStudentRequestDtoList;

    public FindByIdGroupRequestDto(String name, List<AddStudentRequestDto> addStudentRequestDtoList) {
        this.name = name;
        this.addStudentRequestDtoList = addStudentRequestDtoList;
    }
}
