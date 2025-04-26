package com.nhnacademy.exam.service.impl;

import com.nhnacademy.exam.exception.*;
import com.nhnacademy.exam.model.dto.DepartmentMemberResponseDto;
import com.nhnacademy.exam.model.entity.Department;
import com.nhnacademy.exam.model.entity.Member;
import com.nhnacademy.exam.model.entity.MemberDepartment;
import com.nhnacademy.exam.model.entity.composite.MemberDepartmentPk;
import com.nhnacademy.exam.model.request.DepartRequest;
import com.nhnacademy.exam.model.request.MemberDepartmentPkRequest;
import com.nhnacademy.exam.model.request.MemberDepartmentRequest;
import com.nhnacademy.exam.model.request.MemberRequest;
import com.nhnacademy.exam.repository.MemberDepartmentRepository;
import com.nhnacademy.exam.service.DepartmentService;
import com.nhnacademy.exam.service.MemberDepartmentService;
import com.nhnacademy.exam.service.MemberService;
import com.querydsl.core.Tuple;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberDepartmentServiceImpl implements MemberDepartmentService {

    private final MemberDepartmentRepository memberDepartmentRepository;
    private final DepartmentService departmentService;
    private final MemberService memberService;

    @Override
    public boolean existsMemberDepartmentByMemberDepartmentPk(MemberDepartmentPkRequest memberDepartmentPkRequest) {
        if(Objects.isNull(memberDepartmentPkRequest) || Objects.isNull(memberDepartmentPkRequest.getId()) || Objects.isNull(memberDepartmentPkRequest.getDepartmentId()) || memberDepartmentPkRequest.getId().isEmpty() || memberDepartmentPkRequest.getDepartmentId().isEmpty()) {
            throw new EmptyParameterException("Required request parameter 'memberId' for method parameter type String is not present");
        }

        return memberDepartmentRepository.existsMemberDepartmentByMemberDepartmentPk(new MemberDepartmentPk(memberDepartmentPkRequest.getId(), memberDepartmentPkRequest.getDepartmentId()));
    }

    @Override
    public List<Tuple> findMembersByDepartmentId(String departmentId) {
        if(Objects.isNull(departmentId)) {
            throw new EmptyParameterException("Required request parameter 'memberId' for method parameter type String is not present");
        }

        if(departmentId.isEmpty()) {
            throw new EmptyParameterException("Required request parameter 'memberId' for method parameter type String is not present");
        }

        if(!departmentService.existsDepartmentByDepartmentId(departmentId)) {
            throw new NotFoundDepartmentIdException("DepartmentId 값에 해당하는 부서를 찾을 수 없습니다.");
        }

        return memberDepartmentRepository.findMembersByDepartmentId(departmentId);

    }

    @Override
    public void saveMemberDepartment(MemberDepartmentRequest memberDepartmentRequest) {
        if(Objects.isNull(memberDepartmentRequest) || Objects.isNull(memberDepartmentRequest.getId()) || Objects.isNull(memberDepartmentRequest.getName()) || Objects.isNull(memberDepartmentRequest.getDepartmentId()) || Objects.isNull(memberDepartmentRequest.getDepartment())) {
            throw new EmptyParameterException("Required request parameter 'memberId' for method parameter type String is not present");
        }

        String id = memberDepartmentRequest.getId();
        String name = memberDepartmentRequest.getName();
        String departmentId = memberDepartmentRequest.getDepartmentId();
        String department = memberDepartmentRequest.getDepartment();

        if(existsMemberDepartmentByMemberDepartmentPk(new MemberDepartmentPkRequest(id, departmentId))) {
            throw new AlreadyExistsMemberDepartmentException("MemberDepartment 테이블에 이미 존재합니다.");
        }

        if(!memberService.existsMemberByMemberId(id)) {
            memberService.saveMember(new MemberRequest(id, name));
        }

        if(!departmentService.existsDepartmentByDepartmentId(departmentId)) {
            departmentService.saveDepartment(new DepartRequest(departmentId, department));
        }

        memberDepartmentRepository.save(new MemberDepartment(new MemberDepartmentPk(id, departmentId), new Member(id, name), new Department(departmentId, department)));
    }

}
