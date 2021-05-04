package cn.ilanky.web.result.core;


import cn.ilanky.web.result.utils.JacksonUtil;

import java.io.PrintWriter;
import java.util.Map;

/**
 * @author ilanky
 * @date 2021年 04月30日 14:18:25
 */
public class JsonResult extends AbstractResult {
    private static final String RETURN_OBJECT_KEY = "result";

    public JsonResult(StatusCarrier statusCarrier) {
        super(statusCarrier);
    }

    public JsonResult(StatusCarrier statusCarrier, Object result) {
        super(statusCarrier, result);
    }

    @Override
    public void output(PrintWriter printWriter) {
        Map<String, Object> map = statusCarrier.toMap();
        map.put(RETURN_OBJECT_KEY, result);
        printWriter.write(JacksonUtil.json(map));
    }
}
