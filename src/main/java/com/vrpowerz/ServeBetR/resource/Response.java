package com.vrpowerz.ServeBetR.resource;

/**
 * @author Venkataraghavan Yanamandram
 *
 */

public class Response {

    private boolean result;
    private String message;
    private String stackTrace;
    private Object data;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Response(Object data) {
        this(data, "Success");
    }

    public Response(Object data, String message) {
        this(data, message, true);
    }

    public Response(Object data, String message, boolean result) {
        this(data, message, result, "");
    }

    public Response(Object data, String message, boolean result, String stackTrace) {
        this.result = result;
        this.message = message;
        this.stackTrace = stackTrace;
        this.data = data;
    }
}
