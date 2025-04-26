package com.nhnacademy.exam.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentEmployeeResponseDto {

    private DepartmentResponseDto department;
    private MemberResponseDto employee;

}
