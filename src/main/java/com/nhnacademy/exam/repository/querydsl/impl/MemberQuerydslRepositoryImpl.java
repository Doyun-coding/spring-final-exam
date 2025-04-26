package com.nhnacademy.exam.repository.querydsl.impl;

import com.nhnacademy.exam.model.entity.Member;
import com.nhnacademy.exam.model.entity.QMember;
import com.nhnacademy.exam.repository.querydsl.MemberQuerydslRepository;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class MemberQuerydslRepositoryImpl extends QuerydslRepositorySupport implements MemberQuerydslRepository {

    public MemberQuerydslRepositoryImpl() {
        super(Member.class);
    }

}
