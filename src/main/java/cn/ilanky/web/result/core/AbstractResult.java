package cn.ilanky.web.result.core;

/**
 * @author ilanky
 * @date 2021年 04月23日 17:51:46
 */
public abstract class AbstractResult implements Result {
    protected StatusCarrier statusCarrier;
    protected Object result;

    public AbstractResult(StatusCarrier statusCarrier){
        this.statusCarrier = statusCarrier;
    }

    public AbstractResult(StatusCarrier statusCarrier,Object result){
        this.statusCarrier = statusCarrier;
        this.result = result;
    }

    public StatusCarrier getStatusCarrier() {
        return statusCarrier;
    }

    public AbstractResult setStatusCarrier(StatusCarrier statusCarrier) {
        this.statusCarrier = statusCarrier;
        return this;
    }

    public Object getResult() {
        return result;
    }

    public AbstractResult setResult(Object result) {
        this.result = result;
        return this;
    }
}
