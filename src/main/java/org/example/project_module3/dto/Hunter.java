package org.example.project_module3.dto;

import lombok.Data;

@Data
public class Hunter {
    private final int id;
    private final String name;
    private int level = 1;
    private boolean defeat = false;
}
