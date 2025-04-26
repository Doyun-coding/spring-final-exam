package com.nhnacademy.exam.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberDepartmentPkRequest {

    private String id;
    private String departmentId;

}
