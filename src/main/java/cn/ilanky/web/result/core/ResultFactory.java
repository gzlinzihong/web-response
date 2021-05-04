package cn.ilanky.web.result.core;
import cn.ilanky.web.result.utils.SpringContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;

/**
 * @author ilanky
 * @date 2021年 04月30日 14:22:13
 */
@Component
@DependsOn("springContextUtil")
public class ResultFactory implements InitializingBean {
    private static final Logger LOG = LoggerFactory.getLogger(ResultFactory.class);
    private static ResultConfig config;

    public static AbstractResult create(StatusCarrier carrier, Object result){
        return newInstance(new Object[]{carrier, result}, StatusCarrier.class, Object.class);
    }

    public static AbstractResult create(StatusCarrier carrier){
        return newInstance(new Object[]{carrier}, StatusCarrier.class);
    }

    private static AbstractResult newInstance(Object[] param, Class<?>... paramClass){
        Class<? extends AbstractResult> resultClass = config.activeResultClass();
        try {
            Constructor<? extends AbstractResult> constructor = resultClass.getDeclaredConstructor(paramClass);
            return constructor.newInstance(param);
        } catch (Exception e) {
            LOG.error("create result error", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        config = SpringContextUtil.getContext().getBean(ResultConfig.class);
    }
}
