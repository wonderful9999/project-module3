package org.example.project_module3.dto;

import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Hunter {
    private UUID UUID;
    private String name;
    private int stage;
    private int attempts;
}
