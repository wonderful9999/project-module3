package org.example.project_module3.servlet.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.project_module3.dao.HunterDAO;
import org.example.project_module3.dto.Hunter;
import org.example.project_module3.service.HunterService;
import org.example.project_module3.service.StageService;

import java.io.IOException;

@WebFilter(urlPatterns = "/")
public class FilterLoginServlet implements Filter {
    private StageService stageService;
    private HunterService hunterService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        ServletContext servletContext = filterConfig.getServletContext();

        stageService = (StageService) servletContext.getAttribute("stageService");
        hunterService = (HunterService) servletContext.getAttribute("hunterService");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        HttpSession session = req.getSession();

        Hunter hunter = (Hunter) session.getAttribute("Hunter");
        if (hunter == null || !hunterService.contains(hunter)) {
            resp.sendRedirect("/welcome.jsp");
        } else {
            int stage = hunter.getStage();
            resp.sendRedirect(stageService.getStage(stage));
        }
    }
}
