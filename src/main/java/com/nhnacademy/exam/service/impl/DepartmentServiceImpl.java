package com.nhnacademy.exam.service.impl;

import com.nhnacademy.exam.exception.AlreadyExistsDepartmentException;
import com.nhnacademy.exam.exception.NotExistsParameterValueException;
import com.nhnacademy.exam.exception.NotFoundDepartmentIdException;
import com.nhnacademy.exam.exception.RequestBodyException;
import com.nhnacademy.exam.model.entity.Department;
import com.nhnacademy.exam.model.request.DepartRequest;
import com.nhnacademy.exam.repository.DepartmentRepository;
import com.nhnacademy.exam.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public boolean existsDepartmentByDepartmentId(String departmentId) {
        if(Objects.isNull(departmentId)) {
            throw new NotFoundDepartmentIdException("ID에 해당하는 Department가 존재하지 않습니다.");
        }

        return departmentRepository.existsById(departmentId);
    }

    @Override
    public Department findDepartmentByDepartmentId(String departmentId) {
        if(Objects.isNull(departmentId)) {
            throw new NotFoundDepartmentIdException("ID에 해당하는 Department가 존재하지 않습니다.");
        }

        if(!existsDepartmentByDepartmentId(departmentId)) {
            throw new NotFoundDepartmentIdException("ID에 해당하는 Department가 존재하지 않습니다.");
        }

        return departmentRepository.findDepartmentById(departmentId);
    }

    @Override
    public void saveDepartment(DepartRequest departRequest) {
        if(Objects.isNull(departRequest) || Objects.isNull(departRequest.getId()) || Objects.isNull(departRequest.getName()) || departRequest.getId().isEmpty() || departRequest.getName().isEmpty()) {
            throw new RequestBodyException("Response Body 값이 비어있습니다.");
        }

        if(departmentRepository.existsById(departRequest.getId())) {
            throw new AlreadyExistsDepartmentException("ID 값에 해당하는 Department 이미 존재합니다.");
        }

        departmentRepository.save(new Department(departRequest.getId(), departRequest.getName()));
    }

    @Override
    public void updateDepartment(DepartRequest departRequest) {
        if(Objects.isNull(departRequest) || Objects.isNull(departRequest.getId()) || Objects.isNull(departRequest.getName()) || departRequest.getId().isEmpty() || departRequest.getName().isEmpty()) {
            throw new RequestBodyException("Response Body 값이 비어있습니다.");
        }

        if(!departmentRepository.existsById(departRequest.getId())) {
            throw new AlreadyExistsDepartmentException("ID 값에 해당하는 Department 존재하지 않습니다.");
        }

        departmentRepository.updateDepartment(departRequest.getName(), departRequest.getId());
    }

    @Override
    public void deleteDepartmentByDepartmentId(String departmentId) {
        if(Objects.isNull(departmentId)) {
            throw new NotExistsParameterValueException("파라미터 값이 없습니다.");
        }

        if(!departmentRepository.existsById(departmentId)) {
            throw new AlreadyExistsDepartmentException("ID 값에 해당하는 Department 존재하지 않습니다.");
        }

        departmentRepository.deleteDepartmentById(departmentId);
    }


}
