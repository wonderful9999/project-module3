package org.example.project_module3.service;

import lombok.RequiredArgsConstructor;
import org.example.project_module3.dto.Stages;

@RequiredArgsConstructor
public class StageService {
    private final Stages stages;

    public String getStage(int stage) {
        return switch (stage) {
            case 1 -> stages.getFIRST_STAGE();
            case 2 -> stages.getSECOND_STAGE();
            case 3 -> stages.getTHIRD_STAGE();
            case 4 -> stages.getFOURTH_STAGE();
            case 5 -> stages.getFIFTH_STAGE();
            default -> throw new RuntimeException("Inappropriate value");
        };
    }
}
