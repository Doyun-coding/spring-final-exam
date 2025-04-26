package com.nhnacademy.exam.repository;

import com.nhnacademy.exam.model.entity.MemberDepartment;
import com.nhnacademy.exam.model.entity.composite.MemberDepartmentPk;
import com.nhnacademy.exam.repository.querydsl.MemberDepartmentQuerydslRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberDepartmentRepository extends JpaRepository<MemberDepartment, MemberDepartmentPk>, MemberDepartmentQuerydslRepository {

    boolean existsMemberDepartmentByMemberDepartmentPk(MemberDepartmentPk memberDepartmentPk);


}
