package org.example.project_module3.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.project_module3.dto.Hunter;
import org.example.project_module3.service.StageService;

import java.io.IOException;

@RequiredArgsConstructor
@WebServlet(value = "/stages-servlet")
public class StagesServlet extends HttpServlet {
    private final StageService stageService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        Hunter hunter = (Hunter) session.getAttribute("hunter");
        hunter.setStage(hunter.getStage() + 1);

        resp.sendRedirect(stageService.getStage(hunter.getStage()));
    }
}
