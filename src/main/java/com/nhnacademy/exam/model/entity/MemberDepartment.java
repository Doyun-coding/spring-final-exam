package com.nhnacademy.exam.model.entity;

import com.nhnacademy.exam.model.entity.composite.MemberDepartmentPk;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "memberdepartment")
public class MemberDepartment {

    @EmbeddedId
    private MemberDepartmentPk memberDepartmentPk;

    @MapsId("memberId")
    @ManyToOne(optional = true)
    @JoinColumn(name = "member_id")
    private Member member;

    @MapsId("departmentId")
    @ManyToOne(optional = true)
    @JoinColumn(name = "department_id")
    private Department department;

}
