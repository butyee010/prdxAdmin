package com.prdx.admin.dao.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.prdx.admin.bean.PropertiesMappingBean;
import com.prdx.admin.constant.SQLConstants;
import com.prdx.admin.dao.PropertyMappingDAO;

@Repository
public class PropertyMappingDAOImpl implements PropertyMappingDAO{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public String getValue(String key, String group) throws Exception {
		String sql = SQLConstants.SQL_GET_VALUE_PROPERTY_MAPPING;
		String result = "";
		List<String> temp = jdbcTemplate.queryForList(sql, new Object[]{key, group},String.class);
		if(temp != null && temp.size() > 0) {
			result = temp.get(0);
		}
		return result;
	}
	
	@Override
	public List<PropertiesMappingBean> findAll() throws Exception {
		String sql = SQLConstants.SQL_FIND_ALL_PROPERTIES_MAPPING;
		List<PropertiesMappingBean> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<PropertiesMappingBean>(PropertiesMappingBean.class));
		
		return result;
	}

}
