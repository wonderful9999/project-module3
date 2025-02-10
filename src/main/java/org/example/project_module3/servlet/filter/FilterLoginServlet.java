package org.example.project_module3.servlet.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.project_module3.dto.Hunter;
import org.example.project_module3.service.HunterService;
import org.example.project_module3.service.StageService;

import java.io.IOException;

@WebFilter(urlPatterns = "/")
public class FilterLoginServlet implements Filter {
    private final String NAME_ATTRIBUTE_CONTEXT_STAGE_SERVICE = "stageService";
    private final String NAME_ATTRIBUTE_CONTEXT_HUNTER_SERVICE = "hunterService";
    private final String NAME_ATTRIBUTE_SESSION_HUNTER = "hunter";
    private final String URL_WELCOME_JSP = "/welcome.jsp";
    private StageService stageService;
    private HunterService hunterService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        ServletContext servletContext = filterConfig.getServletContext();

        stageService = (StageService) servletContext.getAttribute(NAME_ATTRIBUTE_CONTEXT_STAGE_SERVICE);
        hunterService = (HunterService) servletContext.getAttribute(NAME_ATTRIBUTE_CONTEXT_HUNTER_SERVICE);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        HttpSession session = req.getSession();

        Hunter hunter = (Hunter) session.getAttribute(NAME_ATTRIBUTE_SESSION_HUNTER);
        if (hunter == null || !hunterService.contains(hunter)) {
            req.getRequestDispatcher(URL_WELCOME_JSP).forward(req, resp);
        } else {
            int tempStage = hunter.getStage();
            req.getRequestDispatcher(stageService.getStage(tempStage)).forward(req, resp);
        }
    }
}
