package org.example.project_module3.listener;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.example.project_module3.dao.HunterDAO;
import org.example.project_module3.dto.Stages;
import org.example.project_module3.service.HunterService;
import org.example.project_module3.service.StageService;

import java.io.File;

@WebListener
public class InitializationListener implements ServletContextListener {
    private final String URL_FILE_HUNTERS_JSON = "C:\\Users\\ataic\\IdeaProjects\\project-module3\\src\\main\\resources\\hunters.json";
    private final String NAME_ATTRIBUTE_STAGE_SERVICE = "stageService";
    private final String NAME_ATTRIBUTE_HUNTER_SERVICE = "hunterService";

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();

        ObjectMapper objectMapper = new ObjectMapper(new JsonFactory());
        File file = new File(URL_FILE_HUNTERS_JSON);

        HunterDAO hunterDAO = new HunterDAO(objectMapper, file);
        HunterService hunterService = new HunterService(hunterDAO);
        StageService stageService = new StageService(new Stages());

        servletContext.setAttribute(NAME_ATTRIBUTE_HUNTER_SERVICE, hunterService);
        servletContext.setAttribute(NAME_ATTRIBUTE_STAGE_SERVICE, stageService);

    }
}
