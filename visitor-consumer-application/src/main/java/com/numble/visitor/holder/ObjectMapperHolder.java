package com.numble.visitor.holder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.Objects;

public class ObjectMapperHolder {

    static {
        final ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.registerModule(new JavaTimeModule());

        ObjectMapperHolder.setObjectMapper(objectMapper);
    }

    private static ObjectMapper objectMapper;

    private ObjectMapperHolder() {
    }

    public static void setObjectMapper(ObjectMapper objectMapper) {
        ObjectMapperHolder.objectMapper = objectMapper;
    }

    public static <T> T readValue(String jsonStr, Class<T> clazz) {
        if (Objects.isNull(objectMapper)) {
            throw new IllegalStateException("objectMapper must be not null");
        }

        try {
            return objectMapper.readValue(jsonStr, clazz);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("can't deserialize json str", e);
        }
    }
}
