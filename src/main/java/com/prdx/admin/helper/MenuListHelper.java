package com.prdx.admin.helper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prdx.admin.bean.contact.MenuBean;
import com.prdx.admin.dao.MenuListDAO;

@Component
public class MenuListHelper {
	
	private static MenuListDAO menuListDAO;

	@Autowired
	private void initialDAO(MenuListDAO menuListDAO) {
		MenuListHelper.menuListDAO = menuListDAO;
	}
	
	public static List<MenuBean> findAll() throws Exception {
		
		return menuListDAO.getAll();
	}
	
	public static MenuBean getMenuBeanyKey(String key) throws Exception {
		
		return menuListDAO.getByKey(key);
	}

}
