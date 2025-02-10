package org.example.project_module3.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.project_module3.dto.Hunter;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class HunterDAO {
    private final ObjectMapper objectMapper;
    private final File file;

    public void save(Hunter hunter) {
        try {
            Map<String, Hunter> hunterMap = objectMapper.readValue(file, new TypeReference<Map<String,Hunter>>() {
            });
            hunterMap.put(hunter.getName(), hunter);
            objectMapper.writeValue(file, hunterMap);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean contains(Hunter hunter) {
        try {
            Map<String, Hunter> hunterMap = objectMapper.readValue(file, new TypeReference<Map<String,Hunter>>() {
            });
            if (hunterMap.containsKey(hunter.getName())) {
                return true;
            }
            return false;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean containsName(String name) {
        try {
            Map<String, Hunter> hunterMap = objectMapper.readValue(file, new TypeReference<Map<String,Hunter>>() {
            });
            if (hunterMap.containsKey(name)) {
                return true;
            }
            return false;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Hunter getHunter(String name) {
        try {
            Map<String, Hunter> hunterMap = objectMapper.readValue(file, new TypeReference<Map<String,Hunter>>() {
            });
            return hunterMap.get(name);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
