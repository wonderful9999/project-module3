package org.example.project_module3;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(value = "/")
public class FilterLogin implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        resp.sendRedirect("/hello-servlet");
    }
}
