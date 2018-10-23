package com.prdx.admin.dao;

import java.util.List;

import com.prdx.admin.bean.contact.MenuBean;

public interface MenuListDAO {

	public List<MenuBean> getAll()throws Exception;
	
	public MenuBean getByKey(String key)throws Exception;

}
