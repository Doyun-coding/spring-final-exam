package com.nhnacademy.exam.service;

import com.nhnacademy.exam.model.entity.Department;
import com.nhnacademy.exam.model.request.DepartRequest;

public interface DepartmentService {

    boolean existsDepartmentByDepartmentId(String departmentId);

    Department findDepartmentByDepartmentId(String departmentId);

    void saveDepartment(DepartRequest departRequest);

    void updateDepartment(DepartRequest departRequest);

    void deleteDepartmentByDepartmentId(String departmentId);
}
