package cn.ilanky.web.result.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author ilanky
 * @date 2021年 04月30日 14:26:21
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {
    private static final Logger LOG = LoggerFactory.getLogger(SpringContextUtil.class);
    private static ApplicationContext CONTEXT;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        CONTEXT = applicationContext;
        LOG.info("application context inject success");
    }

    public static ApplicationContext getContext(){
        return CONTEXT;
    }
}
