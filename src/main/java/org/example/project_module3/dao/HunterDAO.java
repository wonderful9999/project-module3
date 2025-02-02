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
        List<Hunter> hunterList = null;
        try {
            hunterList = objectMapper.readValue(file, new TypeReference<List<Hunter>>(){});
            hunterList.add(hunter);
            objectMapper.writeValue(file, hunterList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(Hunter hunter) {

    }

    public void delete(Hunter hunter) {

    }
}
