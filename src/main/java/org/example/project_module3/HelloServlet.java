package org.example.project_module3;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("index.jsp");
    }

    public void destroy() {
    }
}