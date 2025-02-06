package org.example.project_module3.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@RequiredArgsConstructor
public class Hunter {
    private final UUID UUID;
    private final String name;
    private int stage = 1;
}
