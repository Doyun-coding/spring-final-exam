package com.nhnacademy.exam.common.interceptor;

import com.nhnacademy.exam.exception.NotAuthHeaderException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Objects;

@Component
public class AuthHeaderInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handle) throws Exception {

        String auth = request.getHeader("X-USER-ID");

        if(Objects.isNull(auth) || !auth.equals("nhnacademy")) {
            throw new NotAuthHeaderException("권한이 없습니다.");
        }

        return true;
    }
}
