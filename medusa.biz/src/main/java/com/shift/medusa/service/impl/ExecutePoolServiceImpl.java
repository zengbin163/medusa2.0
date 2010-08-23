package com.shift.medusa.service.impl;

import com.shift.medusa.service.ExecutePoolService;

public class ExecutePoolServiceImpl implements ExecutePoolService {

	private static final String SUCCESS = "success";

	@Override
	public String execute(String name) {
		// TODO Auto-generated method stub
		System.out.println("ExecutePoolService execute:" + name);
		return SUCCESS;
	}

}
