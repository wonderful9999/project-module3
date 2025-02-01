package org.example.project_module3.service;

import lombok.AllArgsConstructor;
import org.example.project_module3.dto.ListHunter;
import org.example.project_module3.dto.Hunter;

import java.util.ArrayList;

@AllArgsConstructor
public class AddHunterService {
    private ArrayList<Hunter> hunterArrayList;
    private ListHunter listHunter;

    public AddHunterService(ListHunter listHunter) {
        if (listHunter != null) {
            this.listHunter = listHunter;
            this.hunterArrayList = listHunter.getHunterArrayList();
        } else {
            throw new NullPointerException("ListHunter is null");
        }
    }

    public void add(Hunter hunter) {
        if (hunter != null) {
            hunterArrayList.add(hunter);
        } else {
            throw new NullPointerException("Hunter in \"add\" method is null");
        }
    }
}
