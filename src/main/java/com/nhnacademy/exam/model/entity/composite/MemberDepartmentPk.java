package com.nhnacademy.exam.model.entity.composite;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class MemberDepartmentPk {

    @Column(name = "member_id")
    private String memberId;

    @Column(name = "department_id")
    private String departmentId;

}
