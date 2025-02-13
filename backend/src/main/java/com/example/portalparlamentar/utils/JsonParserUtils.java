package com.example.portalparlamentar.utils;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class JsonParserUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private JsonParserUtils() {
        // Construtor privado, não permitindo instanciamento
    }

    /**
     * Mapeia a string JSON para a classe especificada
     *
     * @param json   string a ser mapeada
     * @param tClass classe de destino
     * @param <T>    tipo da classe
     * @return objeto mapeado da classe especificada
     * @throws IOException em caso de erro ao fazer o parse
     */
    public static <T> T entity(String json, Class<T> tClass) throws IOException {
        JsonNode dadosNode = objectMapper.readTree(json).get("dados");
        return objectMapper.readValue(dadosNode.toString(), tClass);
    }

    /**
     * Mapeia a string JSON para uma lista do tipo especificado
     *
     * @param json   string a ser mapeada
     * @param tClass classe do objeto na lista
     * @param <T>    tipo da classe
     * @return lista de objetos mapeados
     * @throws IOException em caso de erro ao fazer o parse
     */
    public static <T> List<T> list(String json, Class<T> tClass) throws IOException {
        JsonNode dadosNode = objectMapper.readTree(json).get("dados");
        JavaType javaType = objectMapper.getTypeFactory().constructCollectionType(List.class, tClass);
        return objectMapper.readValue(dadosNode.toString(), javaType);
    }

    /**
     * Lê o conteúdo JSON e retorna o nó raiz
     *
     * @param content string JSON a ser lida
     * @return nó raiz do JSON
     * @throws IOException em caso de erro ao ler o JSON
     */
    public static JsonNode readTree(String content) throws IOException {
        return objectMapper.readTree(content);
    }

    /**
     * Converte um objeto para sua representação JSON como string
     *
     * @param object objeto a ser convertido
     * @return string JSON
     * @throws IOException em caso de erro ao converter
     */
    public static String toJson(Object object) throws IOException {
        return objectMapper.writeValueAsString(object);
    }
}
