package com.nhnacademy.exam.repository.querydsl;

import com.nhnacademy.exam.model.entity.Member;
import com.nhnacademy.exam.model.request.MemberDepartmentRequest;
import com.querydsl.core.Tuple;

import java.util.List;

public interface MemberDepartmentQuerydslRepository {

    List<Tuple> findMembersByDepartmentId(String departmentId);

}
