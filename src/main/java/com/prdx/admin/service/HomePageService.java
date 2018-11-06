package com.prdx.admin.service;

import com.prdx.admin.bean.contact.HomeBean;
import com.prdx.admin.bean.form.HomeForm;

public interface HomePageService {

	public HomeBean getHomePage() throws Exception;

	public void editHomePage(HomeForm homeForm)throws Exception;

}
