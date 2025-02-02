package org.example.project_module3.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
public class Hunter {
    private final int id;
    private final String name;
    private int level = 1;
    private boolean defeat = false;
}
