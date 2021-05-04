package cn.ilanky.web.result;

import cn.ilanky.web.result.core.AbstractResult;
import cn.ilanky.web.result.core.CommonResultStatus;
import cn.ilanky.web.result.core.ResultFactory;
import cn.ilanky.web.result.core.StatusCarrier;

/**
 * @author ilanky
 * @date 2021年 04月23日 17:46:00
 */

public class ResultContext {
    private static final ThreadLocal<AbstractResult> HOLDER = new ThreadLocal<>();

    public static AbstractResult set(StatusCarrier carrier){
        AbstractResult result = ResultFactory.create(carrier);
        HOLDER.set(result);
        return result;
    }

    public static AbstractResult set(StatusCarrier carrier,Object o){
        AbstractResult result = ResultFactory.create(carrier, o);
        HOLDER.set(result);
        return result;
    }

    public static AbstractResult get(){
        return HOLDER.get();
    }

    public static void clear(){
        HOLDER.remove();
    }

    public static AbstractResult ok(){
        AbstractResult abstractResult = ResultFactory.create(CommonResultStatus.OK);
        HOLDER.set(abstractResult);
        return abstractResult;
    }

    public static AbstractResult ok(Object result){
        AbstractResult abstractResult = ResultFactory.create(CommonResultStatus.OK, result);
        HOLDER.set(abstractResult);
        return abstractResult;
    }

    public static AbstractResult serverError(){
        AbstractResult abstractResult = ResultFactory.create(CommonResultStatus.INTERNAL_SERVER_ERROR);
        HOLDER.set(abstractResult);
        return abstractResult;
    }

    public static AbstractResult serverError(Object result){
        AbstractResult abstractResult = ResultFactory.create(CommonResultStatus.INTERNAL_SERVER_ERROR, result);
        HOLDER.set(abstractResult);
        return abstractResult;
    }
}
