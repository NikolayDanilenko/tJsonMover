package com.example.jsonmover.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class FindAllGroupsDto {

    private String name;
    private int studentCount;
}
