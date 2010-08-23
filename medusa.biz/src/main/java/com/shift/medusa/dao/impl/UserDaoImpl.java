package com.shift.medusa.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.shift.medusa.dao.UserDao;
import com.shift.object.User;

@Configuration("userDao")
public class UserDaoImpl implements UserDao {

	private SqlMapClientTemplate sqlMapClientTemplate;

	@Override
	public void insertUser(User user) {
		Object ret = sqlMapClientTemplate.insert("User.insert_user", user);
		System.out.println("insertUser output " + ret);
		if (null != ret && ret.toString().equals(1))
			System.out.println("user name:" + user.getName() + "  password:"
					+ user.getPassword());
	}

	/***
	 * 查询所有用户信息
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<User> queryAllUsers() {
		Map<String, Object> map = new HashMap<String, Object>();
		return sqlMapClientTemplate.queryForList("User.queryAllUsers", map);
	}

	@Resource(name = "sqlMapClientTemplate")
	public void setSqlMapClientTemplate(
			SqlMapClientTemplate sqlMapClientTemplate) {
		this.sqlMapClientTemplate = sqlMapClientTemplate;
	}

}
