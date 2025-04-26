package com.nhnacademy.exam.service;

import com.nhnacademy.exam.model.request.MemberRequest;

public interface MemberService {

    boolean existsMemberByMemberId(String memberId);

    void saveMember(MemberRequest memberRequest);

}
