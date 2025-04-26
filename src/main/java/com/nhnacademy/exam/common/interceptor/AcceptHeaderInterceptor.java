package com.nhnacademy.exam.common.interceptor;

import com.nhnacademy.exam.exception.NotAcceptHeaderTypeException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Objects;

@Component
public class AcceptHeaderInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        String getAcceptHeader = request.getHeader("Accept");
        String getContentType = request.getContentType();

        if(getContentType == null && getAcceptHeader.contains("*/*")) {
            return true;
        }

        if(getContentType != null && !getContentType.contains("application/json") && !getContentType.contains("application/xml")) {
            if(!(getAcceptHeader.contains("application/json") || getAcceptHeader.contains("application/xml"))) {
                throw new NotAcceptHeaderTypeException("'Accept: application/json' or 'Accept: application/xml' 헤더만 사용 가능합니다.");
            }
        }

        if(getContentType == null && !(getAcceptHeader.contains("application/json") || getAcceptHeader.contains("application/xml"))) {
            throw new NotAcceptHeaderTypeException("'Accept: application/json' or 'Accept: application/xml' 헤더만 사용 가능합니다.");
        }

        return true;
    }

}
