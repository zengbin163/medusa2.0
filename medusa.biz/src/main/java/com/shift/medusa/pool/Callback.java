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

import java.util.Map;

/**
 * �߳�������ϵĻص��ӿ�
 * 
 */
public interface Callback {
	void call(Map<Object, Object> param);
}
