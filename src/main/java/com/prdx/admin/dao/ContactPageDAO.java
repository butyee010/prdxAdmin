package com.prdx.admin.dao;

public interface ContactPageDAO {

	public String getValue(String key)throws Exception;
	
	public void setValue(String key, String value)throws Exception;
}
