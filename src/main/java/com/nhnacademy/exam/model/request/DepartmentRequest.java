package com.nhnacademy.exam.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentRequest {

    @JsonProperty("사번")
    private String id;

    @JsonProperty("이름")
    private String name;

    @JsonProperty("부서")
    private String department;

    @JsonProperty("부서코드")
    private String departmentId;

}
