package com.nhnacademy.exam.repository;

import com.nhnacademy.exam.model.entity.Member;
import com.nhnacademy.exam.model.request.MemberRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, String> {

    boolean existsById(String id);

}
