package org.example.project_module3.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.project_module3.dto.Hunter;

import java.io.IOException;

@WebServlet(urlPatterns = "/restart-servlet")
public class RestartServlet extends HttpServlet {
    private final int DEFAULT_STAGE = 0;
    private final String NAME_ATTRIBUTE_SESSION_HUNTER = "hunter";
    private final String URL_STAGES_SERVLET = "/stages-servlet";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        Hunter hunter = (Hunter) session.getAttribute(NAME_ATTRIBUTE_SESSION_HUNTER);
        hunter.setStage(DEFAULT_STAGE);
        hunter.setAttempts(hunter.getAttempts() + 1);

        req.getRequestDispatcher(URL_STAGES_SERVLET).forward(req, resp);
    }
}
