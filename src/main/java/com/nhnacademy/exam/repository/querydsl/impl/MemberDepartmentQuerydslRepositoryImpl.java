package com.nhnacademy.exam.repository.querydsl.impl;

import com.nhnacademy.exam.model.entity.*;
import com.nhnacademy.exam.model.request.MemberDepartmentRequest;
import com.nhnacademy.exam.repository.querydsl.MemberDepartmentQuerydslRepository;
import com.querydsl.core.Tuple;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class MemberDepartmentQuerydslRepositoryImpl extends QuerydslRepositorySupport implements MemberDepartmentQuerydslRepository {

    public MemberDepartmentQuerydslRepositoryImpl() {
        super(MemberDepartment.class);
    }

    @Override
    public List<Tuple> findMembersByDepartmentId(String departmentId) {

        QMember qMember = QMember.member;
        QDepartment qDepartment = QDepartment.department;
        QMemberDepartment qMemberDepartment = QMemberDepartment.memberDepartment;

        return from(qMemberDepartment)
                .leftJoin(qMemberDepartment.member, qMember)
                .leftJoin(qMemberDepartment.department, qDepartment)
                .where(qMemberDepartment.department.id.eq(departmentId))
                .select(qMember, qDepartment, qMemberDepartment)
                .fetch();
    }

}
