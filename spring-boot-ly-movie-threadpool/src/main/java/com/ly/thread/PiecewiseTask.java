package com.ly.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 分段线程定制
 */
public class PiecewiseTask extends FutureTask<Boolean> {
    private final PiecewiseKey taskKey;

    public PiecewiseTask(Callable<Boolean> callable, PiecewiseKey taskKey) {
        super(callable);
        this.taskKey = taskKey;
    }

    public PiecewiseKey getTaskKey() {
        return taskKey;
    }
}
