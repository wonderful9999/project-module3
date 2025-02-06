package org.example.project_module3.service;

import lombok.RequiredArgsConstructor;
import org.example.project_module3.dao.HunterDAO;
import org.example.project_module3.dto.Hunter;

@RequiredArgsConstructor
public class HunterService {
    private final HunterDAO hunterDAO;

    public void saveHunter(Hunter hunter) {
        hunterDAO.save(hunter);
    }

    public boolean contains(Hunter hunter) {
        return hunterDAO.contains(hunter);
    }

}
