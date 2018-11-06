package com.prdx.admin.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.prdx.admin.bean.contact.CarouselBean;
import com.prdx.admin.constant.SQLConstants;
import com.prdx.admin.dao.HomePageDAO;

@Repository
public class HomePageDAOImpl implements HomePageDAO{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<CarouselBean> getCarouselList() throws Exception {
		String sql = SQLConstants.SQL_GET_CAROUSEL_LIST;
		List<CarouselBean> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<CarouselBean>(CarouselBean.class));
		
		return result;
	}
	
	@Override
	public String getValue(String key) throws Exception {
		String sql = SQLConstants.SQL_GET_VALUE_HOME_PAGE_BY_KEY;
		String result = "";
		List<String> temp = jdbcTemplate.queryForList(sql, new Object[]{key},String.class);
		if(temp != null && temp.size() > 0) {
			result = temp.get(0);
		}
		return result;
	}

	@Override
	public void setValue(String key, String value, boolean insert) throws Exception {
		String sql = "";
		if(insert) {
			sql = SQLConstants.SQL_SET_INSERT_VALUE_HOME_PAGE_BY_KEY;
		}else {
			sql = SQLConstants.SQL_SET_VALUE_HOME_PAGE_BY_KEY;
		}
		jdbcTemplate.update(sql, new Object[]{value, key});
	}

}
