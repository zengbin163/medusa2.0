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
 * ��¶���̳߳ط���
 * 
 * @author xiaoguang.zhangxg
 */

public interface PoolService {
    /** �ύ����,���ûص��ӿ� */
    void submit(RunTask task, Callback callback);
}
