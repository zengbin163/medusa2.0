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
 * TODO Comment of PoolRejectedExecutionHandler
 * @author xiaoguang.zhangxg
 *
 */

import java.util.concurrent.RejectedExecutionHandler;

import java.util.concurrent.ThreadPoolExecutor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PoolRejectedExecutionHandler implements RejectedExecutionHandler {
    private final Log log = (Log) LogFactory.getLog(PoolRejectedExecutionHandler.class);

    // º”»’÷æ
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        log.error("thread pool can't meet the demand,please add thread number!!!!!!!!");
    }

}
