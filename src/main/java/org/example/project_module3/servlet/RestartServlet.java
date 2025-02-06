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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        Hunter hunter = (Hunter) session.getAttribute("hunter");
        hunter.setStage(1);

        req.getRequestDispatcher("/stages-servlet").forward(req, resp);
    }
}
