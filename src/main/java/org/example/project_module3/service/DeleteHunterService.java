package org.example.project_module3.service;

import org.example.project_module3.dto.ListHunter;
import org.example.project_module3.dto.Hunter;

import java.util.ArrayList;


public class DeleteHunterService {
    private ArrayList<Hunter> hunterArrayList;
    private ListHunter listHunter;

    public DeleteHunterService(ListHunter listHunter) {
        this.listHunter = listHunter;
        this.hunterArrayList = listHunter.getHunterArrayList();
    }
}
