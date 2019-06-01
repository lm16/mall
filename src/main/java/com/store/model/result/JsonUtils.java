package com.store.model.result;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

class JsonUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();

    //对象转字符串
    static <T> String obj2String(T obj) throws JsonProcessingException {
        return obj instanceof String ? (String) obj : objectMapper.writeValueAsString(obj);
    }

    //字符串转对象
    static <T> T string2Obj(String str, Class<T> clazz) throws IOException {
        return clazz.equals(String.class)? (T) str :objectMapper.readValue(str,clazz);
    }
}