package cn.ilanky.web.result.core;

import cn.ilanky.web.result.utils.SpringContextUtil;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ilanky
 * @date 2021年 04月30日 15:47:19
 */
@Configuration
public class ResultGlobalConfig {

    @ConditionalOnMissingBean(ResultConfig.class)
    @Bean
    public ResultConfig resultConfig(){
        return new DefaultResultConfig();
    }
}
