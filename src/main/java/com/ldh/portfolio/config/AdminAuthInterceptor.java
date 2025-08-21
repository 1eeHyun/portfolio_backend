package com.ldh.portfolio.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@RequiredArgsConstructor
public class AdminAuthInterceptor implements HandlerInterceptor {

    @Value("${admin.token}")
    private String adminToken;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        String uri = request.getRequestURI();

        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) return true;

        if (!uri.startsWith("/api/admin")) return true;

        if (uri.startsWith("/api/admin/auth")) return true;

        var session = request.getSession(false);
        if (session != null && Boolean.TRUE.equals(session.getAttribute("ADMIN_AUTH"))) return true;

        // Authorization Header Token (Postman)
        String raw = request.getHeader("Authorization");
        if (raw != null) {
            String trimmed = raw.trim();
            if (trimmed.equals(adminToken) || trimmed.equals("Bearer " + adminToken)) {
                return true;
            }
        }

        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType("text/plain;charset=UTF-8");
        response.getWriter().write("Unauthorized: Invalid or missing admin token.");
        response.getWriter().flush();
        return false;
    }
}
