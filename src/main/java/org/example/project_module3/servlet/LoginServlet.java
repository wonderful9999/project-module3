package org.example.project_module3.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.project_module3.dto.Hunter;
import org.example.project_module3.service.HunterService;

import java.io.IOException;
import java.util.UUID;


@WebServlet(urlPatterns = "/login-servlet")
public class LoginServlet extends HttpServlet {
    private HunterService hunterService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = getServletContext();

        hunterService = (HunterService) servletContext.getAttribute("hunterService");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        Hunter newHunter = new Hunter(UUID.randomUUID(), request.getParameter("name"));

        hunterService.saveHunter(newHunter);
        session.setAttribute("hunter", newHunter);


    }
}