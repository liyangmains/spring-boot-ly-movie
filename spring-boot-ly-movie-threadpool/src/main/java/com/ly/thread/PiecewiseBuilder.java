package com.ly.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * 获取实例工具类
 */
public class PiecewiseBuilder {
    public static PiecewiseKey buildKey(Integer from, Integer to) {
        return new PiecewiseKey(from, to);
    }

    public static <V> PiecewiseResult<V> buildResult(V val) {
        return new PiecewiseResult<V>(val);
    }

    public static <V> PiecewiseResult<V> buildResult(V val, Exception exception) {
        return new PiecewiseResult<V>(val, exception);
    }

    public static PiecewiseTask buildTask(Callable<Boolean> callable, PiecewiseKey taskKey) {
        return new PiecewiseTask(callable, taskKey);
    }

    /**
     * this method aimed for simple when define the nThreadResult
     *
     * @return
     */
    public static <V> Map<PiecewiseKey, PiecewiseResult<Map<PiecewiseKey, PiecewiseResult<V>>>> initializeNThreadResult() {
        return new HashMap<>();
    }

    /**
     * this method aimed for simple when define the threadResult
     *
     * @return
     */
    public static <V> Map<PiecewiseKey, PiecewiseResult<V>> initializeThreadResult() {
        return new HashMap<>();
    }
}
