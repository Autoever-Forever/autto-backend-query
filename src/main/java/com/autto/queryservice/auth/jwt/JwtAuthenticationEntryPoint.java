package com.autto.queryservice.auth.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import com.autto.queryservice.common.response.BaseApiResponse;
import com.autto.queryservice.common.response.ErrorResponseStatus;

import java.io.IOException;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
            throws IOException, ServletException {
        ErrorResponseStatus exception = (ErrorResponseStatus) request.getAttribute("exception");

        if (exception == null) {
            exception = ErrorResponseStatus.UNKNOWN_ERROR;
        }

        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.getWriter()
                .write(
                        objectMapper.writeValueAsString(
                                BaseApiResponse.error(exception.getHttpStatus(), exception.getMessage())
                        )
                );
    }
}
