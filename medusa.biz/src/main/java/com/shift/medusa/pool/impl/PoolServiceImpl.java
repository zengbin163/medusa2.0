/**
 * Function: 
 * 
 * File Created at 2010-3-13
 * $Id$
 * 
 * Copyright 2009 Alibaba.com Croporation Limited.
 * All rights reserved.
 */
package com.shift.medusa.pool.impl;

/**
 * TODO Comment of PoolServiceImpl
 * @author xiaoguang.zhangxg
 *
 */
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.shift.medusa.pool.Callback;
import com.shift.medusa.pool.PoolService;
import com.shift.medusa.pool.RunTask;
import com.shift.medusa.pool.component.NamedThreadFactory;
import com.shift.medusa.pool.component.PoolListenerThread;
import com.shift.medusa.pool.component.PoolRejectedExecutionHandler;

/** spring配成单例 */
@SuppressWarnings("all")
public class PoolServiceImpl implements PoolService {

    private static final Log       log               = LogFactory.getLog(PoolServiceImpl.class);
    /** 可配置属性 */
    private int                    core;
    private int                    max;
    private int                    killDelay;

    private CompletionService<Map> completionService = null;
    private Map<String, Callback>  idMap             = null;
    private BlockingQueue          blockQ;

    public PoolServiceImpl() {

    }

    void init() {
        if (core < 1 || max < core || killDelay < 0)
            throw new AssertionError("please set core,max,killDelay and with right config!");
        idMap = new ConcurrentHashMap<String, Callback>();
        blockQ = new LinkedBlockingQueue<Callable>();
        Executor pool = new ThreadPoolExecutor(core, max, killDelay, TimeUnit.SECONDS, blockQ,
                new NamedThreadFactory("Thread"), new PoolRejectedExecutionHandler());
        completionService = new ExecutorCompletionService(pool);
        new PoolListenerThread(completionService, idMap).start();
    }

    public synchronized void submit(RunTask task, Callback callback) {
        if (!idMap.containsKey(task.getId())) {
            idMap.put(task.getId(), callback);
            completionService.submit(task);
        }
        log();
    }

    public void setCore(int core) {
        this.core = core;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setKillDelay(int killDelay) {
        this.killDelay = killDelay;
    }

    private void log() {
        try {
            Set<String> all = idMap.keySet();
            log.info("============pool processing task=================");
            for (String id : all) {
                log.info("##status: processing##id=" + id + "####");
            }
        } catch (Throwable e) {
            log.error("useless message!", e);
        }
    }

}
