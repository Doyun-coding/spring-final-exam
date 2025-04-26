package com.nhnacademy.exam.controller;

import com.nhnacademy.exam.exception.MissingParameterException;
import com.nhnacademy.exam.exception.NotFoundDepartmentIdException;
import com.nhnacademy.exam.model.domain.DomainMember;
import com.nhnacademy.exam.model.dto.*;
import com.nhnacademy.exam.model.entity.Department;
import com.nhnacademy.exam.model.entity.Member;
import com.nhnacademy.exam.model.entity.QDepartment;
import com.nhnacademy.exam.model.entity.QMember;
import com.nhnacademy.exam.model.request.MemberDepartmentRequest;
import com.nhnacademy.exam.service.MemberDepartmentService;
import com.nhnacademy.exam.service.MemberService;
import com.querydsl.core.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/department-members")
public class DepartmentMemberController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberDepartmentService memberDepartmentService;

//    @GetMapping
//    public ResponseEntity<List<DepartmentMemberResponseDto>> getDepartmentMember(@RequestParam("departmentIds") String requestParam) {
//        List<DepartmentMemberResponseDto> domainMembers = new ArrayList<>();
//        String[] tokens = requestParam.split(",");
//        if(tokens.length == 0) {
//            throw new NotFoundDepartmentIdException("DepartmentId 값을 파라미터로 넘겨주세요.");
//        }
//
//        for(String token : tokens) {
//            List<DepartmentMemberResponseDto> list = memberDepartmentService.findMembersByDepartmentId(token.trim());
//
//            domainMembers.addAll(list);
//        }
//        domainMembers.sort(Comparator.comparing(DepartmentMemberResponseDto::getMemberId));
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(domainMembers);
//    }

    @PostMapping
    public ResponseEntity<MemberDepartmentResponseDto> postMemberDepartment(@RequestBody MemberDepartmentRequest memberDepartmentRequest) {
        if(Objects.isNull(memberDepartmentRequest)) {
            throw new MissingParameterException("Required request parameter for method parameter type String is not present");
        }

        memberDepartmentService.saveMemberDepartment(memberDepartmentRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(new MemberDepartmentResponseDto(memberDepartmentRequest.getId(), memberDepartmentRequest.getName(), memberDepartmentRequest.getDepartmentId(), memberDepartmentRequest.getDepartment()));
    }

    @GetMapping
    public ResponseEntity<List<DepartmentEmployeeResponseDto>> getDepartmentEmployee(@RequestParam(value = "departmentIds", required = false) String departmentIds) {
        if(Objects.isNull(departmentIds)) {
            throw new MissingParameterException("Required request parameter for method parameter type String is not present");
        }

        String[] tokens = departmentIds.trim().split(",");

        if(tokens.length == 0) {
            throw new MissingParameterException("Required request parameter for method parameter type String is not present");
        }

        List<DepartmentEmployeeResponseDto> departmentEmployeeResponseDtos = new ArrayList<>();
        for(int i = 0; i < tokens.length; i++) {
            List<Tuple> list = memberDepartmentService.findMembersByDepartmentId(tokens[i]);

            for(Tuple tuple : list) {
                Member member = tuple.get(QMember.member);
                Department department = tuple.get(QDepartment.department);

                departmentEmployeeResponseDtos.add(new DepartmentEmployeeResponseDto(new DepartmentResponseDto(department.getId(), department.getName()), new MemberResponseDto(member.getId(), member.getName())));
            }

        }

        return ResponseEntity.status(HttpStatus.CREATED).body(departmentEmployeeResponseDtos);
    }

}
