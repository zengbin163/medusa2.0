package com.shift.medusa.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.shift.medusa.pool.RunTask;
import com.shift.medusa.service.ExecutePoolService;
import com.shift.medusa.service.impl.ExecutePoolServiceImpl;

@SuppressWarnings("unchecked")
public class ExecutePoolServiceThread implements RunTask {

	private ExecutePoolService executePoolService;
	private String id;

	@Override
	public Map call() throws Exception {
		// TODO Auto-generated method stub
		executePoolService = new ExecutePoolServiceImpl();
		executePoolService.execute("线程池");
		Map map = new HashMap();
		id = UUID.randomUUID().toString();
		map.put("key", "线程池的返回值");
		return map;
	}

	@Override
	public String getId() {
		return id;
	}

}
