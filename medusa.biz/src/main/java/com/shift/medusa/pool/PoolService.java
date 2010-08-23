/**
 * Function: 
 * 
 * File Created at 2010-3-13
 * $Id$
 * 
 * Copyright 2009 Alibaba.com Croporation Limited.
 * All rights reserved.
 */
package com.shift.medusa.pool;

/**
 * 暴露的线程池服务
 * 
 * @author xiaoguang.zhangxg
 */

public interface PoolService {
    /** 提交任务,调用回调接口 */
    void submit(RunTask task, Callback callback);
}
