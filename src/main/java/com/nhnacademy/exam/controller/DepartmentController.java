package com.nhnacademy.exam.controller;

import com.nhnacademy.exam.model.request.DepartmentRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    @PostMapping("/department")
    public ResponseEntity postDepartment(@RequestBody DepartmentRequest departmentRequest) {

        return ResponseEntity.status(HttpStatus.CREATED).body(departmentRequest);
    }

}
