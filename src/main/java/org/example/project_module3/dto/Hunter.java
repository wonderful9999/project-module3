package org.example.project_module3.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Hunter {
    private final int UUID;
    private final String name;
    private int stage = 1;
    private boolean defeat = false;
}
