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
 * 处理结果回调
 * @author xiaoguang.zhangxg
 *
 */

import java.util.Map;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.shift.medusa.pool.Callback;

@SuppressWarnings("unchecked")
public class PoolListenerThread extends Thread {
    private final Log      log               = LogFactory.getLog(PoolListenerThread.class);
    CompletionService<Map> completionService = null;
    Map<String, Callback>  idMap             = null;

    public PoolListenerThread(CompletionService<Map> completionService, Map<String, Callback> idMap) {
        this.completionService = completionService;
        this.idMap = idMap;
        this.setDaemon(true);
    }

    public void run() {
        while (true) {
            Future<Map> f = null;
            try {
                f = completionService.take();
            } catch (InterruptedException e) {
                log.error("completionService.take() InterruptedException!", e);
            }
            Map resultFromTask = null;
            String key = "";
            try {
                resultFromTask = f.get();
                key = (String) resultFromTask.get("id");
                if (!org.apache.commons.lang.StringUtils.isNotEmpty(key)) {
                    log.error("no this key:" + key + "  Thread goes faiure!");
                    continue;
                }

            } catch (InterruptedException e) {
                log.error("InterruptedException key:" + key + "  Thread goes faiure!", e);
            } catch (ExecutionException e) {
                log.error("ExecutionException key:" + key + "  Thread goes faiure!", e);
            } catch (Throwable e) {
                log.error("f.get()Exception key:" + key + "  Thread goes faiure!", e);
            }
            try {
                Callback call = idMap.get(key);
                if (call != null) {
                    call.call(resultFromTask);
                } else {
                    log.error("can't get callback method,the key =" + key);
                }
                idMap.remove(key);
            } catch (Throwable e) {
                log.error("idMap.get(key)Exception key:" + key + "  Thread goes faiure!", e);
            }
        }

    }

}
