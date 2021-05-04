package cn.ilanky.web.result.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ilanky
 * @date 2021年 04月30日 14:10:43
 */
public class JacksonUtil {
    private static final Logger LOG = LoggerFactory.getLogger(JacksonUtil.class);

    public static String json(Object o){
        ObjectMapper mapper = ObjectMapperHolder.get();
        try {
            return mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            LOG.error("to json error", e);
        }
        return "";
    }
}
