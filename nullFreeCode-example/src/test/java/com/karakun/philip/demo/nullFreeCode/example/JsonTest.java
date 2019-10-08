package com.karakun.philip.demo.nullFreeCode.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {

    @Test
    void createSimpleSquirrel() throws JsonProcessingException {
        Squirrel squirrel = ImmutableSquirrel.builder()
                .gender(Gender.MALE)
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new Jdk8Module());
        String json = objectMapper.writeValueAsString(squirrel);

        assertEquals("{\"gender\":\"MALE\",\"mother\":null,\"father\":null}", json);
    }
}
