package com.nhnacademy.exam.service.impl;

import com.nhnacademy.exam.exception.AlreadyExistsMemberException;
import com.nhnacademy.exam.exception.EmptyParameterException;
import com.nhnacademy.exam.exception.NotFoundDepartmentIdException;
import com.nhnacademy.exam.exception.RequestBodyException;
import com.nhnacademy.exam.model.domain.DomainMember;
import com.nhnacademy.exam.model.dto.DepartmentMemberResponseDto;
import com.nhnacademy.exam.model.entity.Member;
import com.nhnacademy.exam.model.request.MemberRequest;
import com.nhnacademy.exam.repository.MemberRepository;
import com.nhnacademy.exam.service.DepartmentService;
import com.nhnacademy.exam.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final DepartmentService departmentService;


    @Override
    public boolean existsMemberByMemberId(String memberId) {
        if(Objects.isNull(memberId)) {
            throw new EmptyParameterException("Required request parameter 'memberId' for method parameter type String is not present");
        }

        return memberRepository.existsById(memberId);
    }

    @Override
    public void saveMember(MemberRequest memberRequest) {
        if(Objects.isNull(memberRequest) || Objects.isNull(memberRequest.getId()) || memberRequest.getId().isEmpty() || Objects.isNull(memberRequest.getName()) || memberRequest.getName().isEmpty()) {
            throw new RequestBodyException("RequestBody 값이 비어있습니다.");
        }

        if(memberRepository.existsById(memberRequest.getId())) {
            throw new AlreadyExistsMemberException("ID 값에 해당하는 Member 이미 존재합니다.");
        }

        memberRepository.save(new Member(memberRequest.getId(), memberRequest.getName()));
    }

}
