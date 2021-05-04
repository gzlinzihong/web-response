package cn.ilanky.web.result.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Optional;

/**
 * @author ilanky
 * @date 2021年 04月30日 14:11:50
 */
public class ObjectMapperHolder {
    private static final ThreadLocal<ObjectMapper> MAPPER_HOLDER = new ThreadLocal<>();

    public static ObjectMapper get(){
        Optional<ObjectMapper> mapper = Optional.ofNullable(MAPPER_HOLDER.get());
        if (mapper.isPresent()){
            return mapper.get();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        MAPPER_HOLDER.set(objectMapper);
        return objectMapper;
    }
}
