package org.example.project_module3.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Getter
@NoArgsConstructor
public class Stages {


    Map<Integer, String> mapStages;
    {
        mapStages = new HashMap<>() {{
            put(1, "/firstStages.jsp");
            put(2, "/secondStages.jsp");
            put(3, "/thirdStages.jsp");
            put(4, "/fourthStages.jsp");
        }};
    }
}
