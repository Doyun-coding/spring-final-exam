package com.nhnacademy.exam.common.advice;

import com.nhnacademy.exam.exception.*;
import com.nhnacademy.exam.model.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class WebRestControllerAdvice {

    @ExceptionHandler(NotRequestExtensionException.class)
    public ResponseEntity<String> notRequestExtensionException(Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(NotFoundDepartmentIdException.class)
    public ResponseEntity<DepartNotFoundResponseDto> notFoundDepartmentIdException(Exception ex) {
        DepartNotFoundResponseDto departNotFoundResponseDto = new DepartNotFoundResponseDto(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(departNotFoundResponseDto);
    }

    @ExceptionHandler(NotFoundMemberIdException.class)
    public ResponseEntity<MemberNotFoundResponseDto> notFoundMemberIdException(Exception ex) {
        MemberNotFoundResponseDto memberNotFoundResponseDto = new MemberNotFoundResponseDto(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(memberNotFoundResponseDto);
    }

    @ExceptionHandler(NotAcceptHeaderTypeException.class)
    public ResponseEntity<String> notAcceptHeaderTypeException(Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(NotAuthHeaderException.class)
    public ResponseEntity<String> notAuthHeaderException(Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(RequestBodyException.class)
    public ResponseEntity<String> requestBodyException(Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(AlreadyExistsMemberException.class)
    public ResponseEntity<MemberDuplicateResponseDto> alreadyExistsMemberException(Exception ex) {
        MemberDuplicateResponseDto memberDuplicateResponseDto = new MemberDuplicateResponseDto(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(memberDuplicateResponseDto);
    }

    @ExceptionHandler(AlreadyExistsDepartmentException.class)
    public ResponseEntity<DepartmentDuplicateResponseDto> alreadyExistsDepartmentException(Exception ex) {
        DepartmentDuplicateResponseDto departmentDuplicateResponseDto = new DepartmentDuplicateResponseDto(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(departmentDuplicateResponseDto);
    }

    @ExceptionHandler(AlreadyExistsMemberDepartmentException.class)
    public ResponseEntity<MemberDepartmentDuplicateResponseDto> alreadyExistsMemberDepartmentException(Exception ex) {
        MemberDepartmentDuplicateResponseDto memberDepartmentDuplicateResponseDto = new MemberDepartmentDuplicateResponseDto(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(memberDepartmentDuplicateResponseDto);
    }

    @ExceptionHandler(NotExistsParameterValueException.class)
    public ResponseEntity<MemberDuplicateResponseDto> notExistsParameterValueException(Exception ex) {
        MemberDuplicateResponseDto memberDuplicateResponseDto = new MemberDuplicateResponseDto(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(memberDuplicateResponseDto);
    }

    @ExceptionHandler(EmptyParameterException.class)
    public ResponseEntity<EmptyParameterResponseDto> emptyParameterException(Exception ex) {
        EmptyParameterResponseDto emptyParameterResponseDto = new EmptyParameterResponseDto(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(emptyParameterResponseDto);
    }

    @ExceptionHandler(MissingParameterException.class)
    public ResponseEntity<MissingParameterResponseDto> missingParameterException(Exception ex) {
        MissingParameterResponseDto missingParameterResponseDto = new MissingParameterResponseDto(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(missingParameterResponseDto);
    }
}
