package com.prdx.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prdx.admin.bean.contact.AboutBean;
import com.prdx.admin.bean.form.AboutForm;
import com.prdx.admin.dao.AboutPageDAO;
import com.prdx.admin.service.AboutPageService;

@Service
public class AboutPageServiceImpl implements AboutPageService {

	@Autowired
	private AboutPageDAO aboutPageDAO;
	
	@Override
	public AboutBean getAboutPage() throws Exception{
		AboutBean aboutBean = new AboutBean();
		aboutBean.setContentHeader1(aboutPageDAO.getValue("TOPIC_DIV_1"));
		aboutBean.setContentDesc1(aboutPageDAO.getValue("CONTENT_DIV_1"));
		aboutBean.setContentHeader2(aboutPageDAO.getValue("TOPIC_DIV_2"));
		aboutBean.setContentDesc2(aboutPageDAO.getValue("CONTENT_DIV_2"));
		aboutBean.setContentHeader3(aboutPageDAO.getValue("TOPIC_DIV_3"));
		aboutBean.setContentDesc3(aboutPageDAO.getValue("CONTENT_DIV_3"));
		aboutBean.setContentHeader4(aboutPageDAO.getValue("TOPIC_DIV_4"));
		aboutBean.setContentDesc4(aboutPageDAO.getValue("CONTENT_DIV_4"));
		
		return aboutBean;
	}

	@Override
	public void editAboutPage(AboutForm aboutForm) throws Exception {
		aboutPageDAO.setValue("TOPIC_DIV_1", aboutForm.getContentHeader1());
		aboutPageDAO.setValue("CONTENT_DIV_1", aboutForm.getContentDesc1());
		aboutPageDAO.setValue("TOPIC_DIV_2", aboutForm.getContentHeader2());
		aboutPageDAO.setValue("CONTENT_DIV_2", aboutForm.getContentDesc2());
		aboutPageDAO.setValue("TOPIC_DIV_3", aboutForm.getContentHeader3());
		aboutPageDAO.setValue("CONTENT_DIV_3", aboutForm.getContentDesc3());
		aboutPageDAO.setValue("TOPIC_DIV_4", aboutForm.getContentHeader4());
		aboutPageDAO.setValue("CONTENT_DIV_4", aboutForm.getContentDesc4());
	}

}
