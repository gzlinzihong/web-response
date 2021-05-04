package cn.ilanky.web.result.core;

/**
 * @author ilanky
 * @date 2021年 04月30日 14:39:17
 */
public interface ResultConfig {

    Class<? extends AbstractResult> activeResultClass();
}
