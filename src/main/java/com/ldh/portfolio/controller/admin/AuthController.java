package com.ldh.portfolio.controller.admin;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/admin/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    public record LoginReq(String token) {}

    @Value("${admin.token:${ADMIN_TOKEN:}}")
    private String adminToken;

    @PostMapping("/login")
    public void login(@RequestBody(required = false) LoginReq req, HttpServletRequest httpReq) {

        String provided = (req != null ? req.token() : null);
        if (provided == null || provided.isBlank()) {
            String raw = httpReq.getHeader("Authorization");
            if (raw != null) {
                raw = raw.trim();
                provided = raw.regionMatches(true,0,"Bearer ",0,7) ? raw.substring(7) : raw;
            }
        }
        String configured = normalize(adminToken);
        String got = normalize(provided);
        if (configured == null || configured.isEmpty()) throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Admin token not configured");
        if (!configured.equals(got)) throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid token");

        httpReq.getSession(true).setAttribute("ADMIN_AUTH", true);
    }

    private static String normalize(String s) {
        if (s == null) return null;
        String t = s.trim();
        if ((t.startsWith("\"") && t.endsWith("\"")) || (t.startsWith("'") && t.endsWith("'"))) {
            t = t.substring(1, t.length()-1);
        }
        t = t.replaceAll("[\\u200B\\u200C\\u200D\\uFEFF]", ""); // zero-width
        t = t.replace('\u00A0',' ').trim(); // NBSP -> space
        return t;
    }


    @PostMapping("/logout")
    public void logout(HttpServletRequest req) {
        var s = req.getSession(false);
        if (s != null) s.invalidate();
    }

    @GetMapping("/me")
    public void me(HttpServletRequest req) {
        var s = req.getSession(false);
        if (s == null || !Boolean.TRUE.equals(s.getAttribute("ADMIN_AUTH"))) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
    }
}
