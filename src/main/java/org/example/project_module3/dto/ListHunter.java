package org.example.project_module3.dto;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ListHunter {
    @Getter
    private ArrayList<Hunter> hunterArrayList;

    public ListHunter(ArrayList<Hunter> unterArrayList) {
        this.hunterArrayList = hunterArrayList;
    }

    public ListHunter(File file) {
        try {
            ObjectMapper objectMapper = new ObjectMapper(new JsonFactory());
            this.hunterArrayList = objectMapper.readValue(file, ArrayList.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
