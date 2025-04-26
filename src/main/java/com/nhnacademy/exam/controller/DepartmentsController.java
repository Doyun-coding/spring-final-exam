package com.nhnacademy.exam.controller;

import com.nhnacademy.exam.model.dto.DepartmentResponseDto;
import com.nhnacademy.exam.model.dto.MemberResponseDto;
import com.nhnacademy.exam.model.entity.Department;
import com.nhnacademy.exam.model.request.DepartRequest;
import com.nhnacademy.exam.model.request.DepartmentNameRequest;
import com.nhnacademy.exam.model.request.MemberRequest;
import com.nhnacademy.exam.service.DepartmentService;
import com.nhnacademy.exam.service.MemberDepartmentService;
import com.nhnacademy.exam.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class DepartmentsController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private MemberDepartmentService memberDepartmentService;

    @PostMapping
    public ResponseEntity<DepartmentResponseDto> postDepartment(@RequestBody DepartRequest departRequest) {


        departmentService.saveDepartment(departRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(new DepartmentResponseDto(departRequest.getId(), departRequest.getName()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentResponseDto> getDepartment(@PathVariable("id") String id) {
        Department department = departmentService.findDepartmentByDepartmentId(id);

        return ResponseEntity.status(HttpStatus.CREATED).body(new DepartmentResponseDto(department.getId(), department.getName()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentResponseDto> putDepartment(@PathVariable("id") String id,
                                                               @RequestBody DepartmentNameRequest departmentNameRequest) {
        departmentService.updateDepartment(new DepartRequest(id, departmentNameRequest.getName()));

        return ResponseEntity.status(HttpStatus.CREATED).body(new DepartmentResponseDto(id, departmentNameRequest.getName()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DepartmentResponseDto> deleteDepartment(@PathVariable("id") String id) {
        Department department = departmentService.findDepartmentByDepartmentId(id);
        departmentService.deleteDepartmentByDepartmentId(id);

        return ResponseEntity.status(HttpStatus.CREATED).body(new DepartmentResponseDto(department.getId(), department.getName()));
    }


}
