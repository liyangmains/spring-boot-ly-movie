package com.ly.thread;

/**
 * 分段任务返回值类
 * @param <V>
 */
public class PiecewiseResult<V> {
    private final V val;
    private Exception exception;

    public PiecewiseResult(V val) {
        super();
        this.val = val;
    }

    public PiecewiseResult(V val, Exception exception) {
        super();
        this.val = val;
        this.exception = exception;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public V getVal() {
        return val;
    }
}
