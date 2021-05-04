package cn.ilanky.web.result.core;

/**
 * @author ilanky
 * @date 2021年 04月30日 14:38:17
 */
public class DefaultResultConfig implements ResultConfig{

    @Override
    public Class<? extends AbstractResult> activeResultClass() {
        return JsonResult.class;
    }
}
