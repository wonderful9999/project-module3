package org.example.project_module3.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.project_module3.dto.Hunter;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
public class HunterDAO {
    private final ObjectMapper objectMapper;
    private final File file;

    public void save(Hunter hunter) {
        try {
            List<Hunter> hunterList = objectMapper.readValue(file, new TypeReference<>() {
            });
            hunterList.add(hunter);
            objectMapper.writeValue(file, hunterList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean contains(Hunter hunter) {
        try {
            List<Hunter> hunterList = objectMapper.readValue(file, new TypeReference<>() {
            });
            if (hunterList.contains(hunter)) {
                return true;
            }
            return false;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
