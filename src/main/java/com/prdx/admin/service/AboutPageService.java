package com.prdx.admin.service;

import com.prdx.admin.bean.contact.AboutBean;
import com.prdx.admin.bean.form.AboutForm;

public interface AboutPageService {

	public AboutBean getAboutPage()throws Exception;

	public void editAboutPage(AboutForm aboutForm)throws Exception;

}
