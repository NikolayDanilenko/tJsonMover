package com.example.jsonmover.error;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ErrorDto {



    
    private int code;
    private String description;
    private LocalDateTime timestamp;

    public ErrorDto(int code, String description) {
        this.code = code;
        this.description = description;
        this.timestamp = LocalDateTime.now();


    }
}
