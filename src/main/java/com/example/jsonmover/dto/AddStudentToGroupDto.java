package com.example.jsonmover.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddStudentToGroupDto {

    private String fullName;
    private Integer id;
}
