package cn.ilanky.web.result.core;

/**
 * @author ilanky
 * @date 2021年 04月30日 14:52:48
 */
public class ResultRuntimeException extends RuntimeException {
    private StatusCarrier carrier;
    private Object result;

    public ResultRuntimeException(StatusCarrier carrier) {
        super(carrier.toString());
        this.carrier = carrier;
    }

    public ResultRuntimeException(String message, StatusCarrier carrier) {
        super(message);
        this.carrier = carrier;
    }

    public ResultRuntimeException(String message, Throwable cause, StatusCarrier carrier) {
        super(message, cause);
        this.carrier = carrier;
    }

    public ResultRuntimeException(Throwable cause, StatusCarrier carrier) {
        super(cause);
        this.carrier = carrier;
    }

    public ResultRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, StatusCarrier carrier) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.carrier = carrier;
    }

    public ResultRuntimeException(StatusCarrier carrier, Object result) {
        super(carrier.toString());
        this.carrier = carrier;
        this.result = result;
    }

    public ResultRuntimeException(String message, StatusCarrier carrier, Object result) {
        super(message);
        this.carrier = carrier;
        this.result = result;
    }

    public ResultRuntimeException(String message, Throwable cause, StatusCarrier carrier, Object result) {
        super(message, cause);
        this.carrier = carrier;
        this.result = result;
    }

    public ResultRuntimeException(Throwable cause, StatusCarrier carrier, Object result) {
        super(cause);
        this.carrier = carrier;
        this.result = result;
    }

    public ResultRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, StatusCarrier carrier, Object result) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.carrier = carrier;
        this.result = result;
    }

    public StatusCarrier getCarrier() {
        return carrier;
    }

    public Object getResult() {
        return result;
    }
}
