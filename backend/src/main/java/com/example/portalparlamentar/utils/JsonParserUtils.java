package com.example.portalparlamentar.utils;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.util.ArrayList;

public class JsonParserUtils {

    private static ObjectMapper objectMapper;

    /**
     * Cria um {@link ObjectMapper} para mapear objetos json.
     *
     * @return created {@link ObjectMapper}
     */
    private static ObjectMapper getMapper() {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }
        return objectMapper;
    }

    /**
     * Mapeia a string json para a classe especificada
     *
     * @param json   string to parse
     * @param tClass class of object in which json will be parsed
     * @param <T>    generic parameter for tClass
     * @return mapped T class instance
     * @throws IOException
     */
    public static <T> T entity(String json, Class<T> tClass) throws IOException {
        return getMapper().readValue(json, tClass);
    }

    /**
     * Mapeia string json para {@link ArrayList} de instâncias de objeto de classe especificadas
     *
     * @param json   string to parse
     * @param tClass class of object in which json will be parsed
     * @param <T>    generic parameter for tClass
     * @return mapped T class instance
     * @throws IOException
     */
    public static <T> ArrayList<T> arrayList(String json, Class<T> tClass) throws IOException {
        TypeFactory typeFactory = getMapper().getTypeFactory();
        JavaType type = typeFactory.constructCollectionType(ArrayList.class, tClass);
        return getMapper().readValue(json, type);
    }

    /**
     * Grava o objeto especificado como string
     *
     * @param object object to write
     * @return result json
     * @throws IOException
     */
    public static String toJson(Object object) throws IOException {
        return getMapper().writeValueAsString(object);
    }

    /**
     * Obter o nó da raiz json
     *
     * @param content
     * @return
     * @throws IOException
     */
    public static JsonNode readTree(String content) throws IOException {
        return getMapper().readTree(content);
    }
}
