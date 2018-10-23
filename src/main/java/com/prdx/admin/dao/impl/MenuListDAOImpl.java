package com.prdx.admin.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.prdx.admin.bean.contact.MenuBean;
import com.prdx.admin.constant.SQLConstants;
import com.prdx.admin.dao.MenuListDAO;

@Repository
public class MenuListDAOImpl implements MenuListDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<MenuBean> getAll() throws Exception {
		String sql = SQLConstants.SQL_GET_ALL_MENU_LIST;
		List<MenuBean> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<MenuBean>(MenuBean.class));
		return result;
	}

	@Override
	public MenuBean getByKey(String key) throws Exception {
		String sql = SQLConstants.SQL_GET_MENU_LIST_BY_KEY;
		MenuBean result = new MenuBean();
		List<MenuBean> temp = jdbcTemplate.query(sql,new Object[]{key}, new BeanPropertyRowMapper<MenuBean>(MenuBean.class));
		if(temp != null && temp.size() > 0) {
			result = temp.get(0);
		}
		return result;
	}



}
