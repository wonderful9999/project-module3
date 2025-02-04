package org.example.project_module3.servlet.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.project_module3.dto.Hunter;
import org.example.project_module3.service.StageService;

import java.io.IOException;

@RequiredArgsConstructor
//@WebFilter()
public class FilterLoginServlet implements Filter {
    private final StageService stageService;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        HttpSession session = req.getSession();

        Hunter hunter = (Hunter) session.getAttribute("Hunter");
        if (hunter == null) {
            resp.sendRedirect("/login-servlet");
        } else {
            int stage = hunter.getStage();
            resp.sendRedirect(stageService.getStage(stage));
        }
    }
}
