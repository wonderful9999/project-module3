package org.example.project_module3.servlet;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.RequiredArgsConstructor;
import org.example.project_module3.service.HunterService;

@RequiredArgsConstructor
@WebServlet(value = "/login-servlet")
public class LoginServlet extends HttpServlet {
    private final HunterService hunterService;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/welcome.jsp");

    }
}