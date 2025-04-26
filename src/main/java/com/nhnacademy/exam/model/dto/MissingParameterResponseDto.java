package com.nhnacademy.exam.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MissingParameterResponseDto {

    private String title;
    private int status;
    private LocalDateTime timestamp;

}
