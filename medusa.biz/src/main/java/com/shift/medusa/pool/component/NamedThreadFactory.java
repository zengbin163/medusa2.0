/**
 * Function: 
 * 
 * File Created at 2010-3-13
 * $Id$
 * 
 * Copyright 2009 Alibaba.com Croporation Limited.
 * All rights reserved.
 */
package com.shift.medusa.pool.component;

/**
 * TODO Comment of NamedThreadFactory
 * @author xiaoguang.zhangxg
 *
 */

import java.util.concurrent.ThreadFactory;

import org.apache.commons.logging.LogFactory;

import org.apache.commons.logging.Log;

public class NamedThreadFactory implements ThreadFactory {
    public static final NamedThreadFactory DEFAULT_FACTORY = new NamedThreadFactory();

    /** Ãû³Æ */
    private String                         name;

    int                                    x               = 0;

    public NamedThreadFactory(String name) {
        this.name = name;
    }

    public NamedThreadFactory() {
    }

    public Thread newThread(Runnable runnable) {
        String tname = name + "---" + x;
        x++;
        return newThread(runnable, tname);
    }

    private Thread newThread(Runnable runnable, String tname) {
        Thread thread = new Thread(runnable, tname);
        thread.setUncaughtExceptionHandler(new TUEHLogger());
        return thread;
    }

    public static class TUEHLogger implements Thread.UncaughtExceptionHandler {
        private final Log log = LogFactory.getLog(TUEHLogger.class);

        public void uncaughtException(Thread t, Throwable e) {
            log.error(t.getName(), e);
        }
    }
}
