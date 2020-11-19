package com.woongjin.woongs.model;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class Admin_randomDao extends SqlSessionDaoSupport{
	
	public void admin_randomAdd(Admin_randomDto ardto) {
		getSqlSession().insert("admin_random.admin_randomAdd",ardto);
	}

}
