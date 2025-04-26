package com.nhnacademy.exam.service;

import com.nhnacademy.exam.model.dto.DepartmentMemberResponseDto;
import com.nhnacademy.exam.model.entity.Member;
import com.nhnacademy.exam.model.request.MemberDepartmentPkRequest;
import com.nhnacademy.exam.model.request.MemberDepartmentRequest;
import com.querydsl.core.Tuple;

import java.util.List;

public interface MemberDepartmentService {

    boolean existsMemberDepartmentByMemberDepartmentPk(MemberDepartmentPkRequest memberDepartmentPkRequest);

    List<Tuple> findMembersByDepartmentId(String departmentId);

    void saveMemberDepartment(MemberDepartmentRequest memberDepartmentRequest);

}
