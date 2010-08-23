package com.shift.medusa;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shift.medusa.pool.PoolService;

public class PoolServiceTest extends TestCase {

	/**
	 * @param args
	 */
	public void testMain() {
		// TODO Auto-generated method stub

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring3.xml");
		PoolService poolService = context.getBean("poolService",
				PoolService.class);
		/**
		 * RunTask runTask = new ExecutePoolServiceThread();
		 * poolService.submit(runTask, null);'
		 **/
	}
}
