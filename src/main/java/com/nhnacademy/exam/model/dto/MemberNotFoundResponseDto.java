package com.nhnacademy.exam.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberNotFoundResponseDto {

    private String title;
    private int status;
    private LocalDateTime timestamp;

}
