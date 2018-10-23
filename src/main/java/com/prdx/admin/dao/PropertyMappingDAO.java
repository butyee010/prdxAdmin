package com.prdx.admin.dao;

import java.util.List;

import com.prdx.admin.bean.PropertiesMappingBean;

public interface PropertyMappingDAO {

	public String getValue(String key, String group)throws Exception;

	public List<PropertiesMappingBean> findAll() throws Exception;

}
