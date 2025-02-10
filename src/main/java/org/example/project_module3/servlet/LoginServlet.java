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
    private final int DEFAULT_STAGE = 0;
    private final int DEFAULT_ATTEMPTS = 0;
    private final String NAME_ATTRIBUTE_SESSION_HUNTER = "hunter";
    private final String NAME_ATTRIBUTE_CONTEXT_HUNTER_SERVICE = "hunterService";
    private final String URLPARAMETER_NAME = "name";
    private final String URL_STAGES_SERVLET = "/stages-servlet";
    private HunterService hunterService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = getServletContext();
        hunterService = (HunterService) servletContext.getAttribute(NAME_ATTRIBUTE_CONTEXT_HUNTER_SERVICE);
    }



    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        String name = req.getParameter(URLPARAMETER_NAME);

        if (hunterService.containsName(name)) {
            session.setAttribute(NAME_ATTRIBUTE_SESSION_HUNTER, hunterService.getHunter(name));
            resp.sendRedirect(URL_STAGES_SERVLET);
            return;
        }

        Hunter newHunter = new Hunter(UUID.randomUUID(), name, DEFAULT_STAGE, DEFAULT_ATTEMPTS);
        hunterService.saveHunter(newHunter);
        session.setAttribute(NAME_ATTRIBUTE_SESSION_HUNTER, newHunter);
        resp.sendRedirect(URL_STAGES_SERVLET);
    }
}