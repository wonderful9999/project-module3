package org.example.project_module3.service;

import lombok.AllArgsConstructor;
import org.example.project_module3.dto.ListHunter;
import org.example.project_module3.dto.Hunter;

import java.util.ArrayList;

@AllArgsConstructor
public class CheckHunterService {
    private ArrayList<Hunter> hunterArrayList;
    private ListHunter listHunter;

    public CheckHunterService(ListHunter listHunter) {
        if (listHunter != null) {
            this.listHunter = listHunter;
            this.hunterArrayList = listHunter.getHunterArrayList();
        } else {
            throw new NullPointerException("ListHunter is null");
        }
    }

    boolean check(Hunter hunter) {
        if (hunterArrayList.contains(hunter)) {
            return true;
        }
        return false;
    }
}
