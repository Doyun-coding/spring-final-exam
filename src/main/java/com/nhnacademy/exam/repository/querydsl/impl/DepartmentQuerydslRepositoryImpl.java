package com.nhnacademy.exam.repository.querydsl.impl;

import com.nhnacademy.exam.model.entity.Department;
import com.nhnacademy.exam.model.entity.QDepartment;
import com.nhnacademy.exam.model.request.DepartRequest;
import com.nhnacademy.exam.repository.querydsl.DepartmentQuerydslRepository;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class DepartmentQuerydslRepositoryImpl extends QuerydslRepositorySupport implements DepartmentQuerydslRepository {
    public DepartmentQuerydslRepositoryImpl() {
        super(Department.class);
    }

}
