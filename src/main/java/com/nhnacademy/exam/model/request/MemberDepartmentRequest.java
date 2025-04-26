package com.nhnacademy.exam.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberDepartmentRequest {

    private String id;
    private String name;
    private String departmentId;
    private String department;

}
