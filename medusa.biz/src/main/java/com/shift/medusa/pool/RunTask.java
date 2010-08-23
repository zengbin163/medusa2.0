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
import java.util.concurrent.Callable;

/**
 * ��Ҫ�����̳߳ش����������Ҫʵ�ָýӿ�,
 * 
 */
@SuppressWarnings("unchecked")
public interface RunTask extends Callable<Map> {
	/** ����Ψһ��ʶ */
	String getId();

	/** Լ��:�ڷ��ص�map�б����key:id,value:Ψһ��ʶ */
	Map call() throws Exception;
}
