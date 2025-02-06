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
import org.example.project_module3.service.StageService;

import java.io.IOException;


@WebServlet(urlPatterns = "/stages-servlet")
public class StagesServlet extends HttpServlet {
    private StageService stageService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext = getServletContext();

        stageService = (StageService) servletContext.getAttribute("stageService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        Hunter hunter = (Hunter) session.getAttribute("hunter");
        hunter.setStage(hunter.getStage() + 1);

        resp.sendRedirect(stageService.getStage(hunter.getStage()));
    }
}
